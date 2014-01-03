package me.arganzheng.project.reading.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.constants.BookStatus;
import me.arganzheng.project.reading.criteria.BookPagingCriteria;
import me.arganzheng.project.reading.dao.BookDao;
import me.arganzheng.project.reading.dao.BookLeadingDao;
import me.arganzheng.project.reading.dao.BookOwnershipDao;
import me.arganzheng.project.reading.exception.ResourceAlreadyExistException;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.model.BookLeading;
import me.arganzheng.project.reading.model.BookOwnership;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author arganzheng
 * @date 2013-12-14
 */
@Service
public class BookService {

    private static final Logger logger = Logger.getLogger(BookService.class);

    @Autowired
    private BookDao             bookDao;
    @Autowired
    private BookOwnershipDao    bookOwnershipDao;

    @Autowired
    private BookLeadingDao      bookLeadingDao;

    public Book getBookById(int id, boolean includeOwnership) {
        Book book = bookDao.selectBookById(id);
        if (book != null && includeOwnership) {
            book.setOwnerships(bookOwnershipDao.selectBookOwnershipByBookId(book.getId()));
        }
        return book;
    }

    public Book getBookByISBN(String isbn, boolean includeOwnership) {
        Book book = bookDao.selectBookByISBN(isbn);
        if (book != null && includeOwnership) {
            book.setOwnerships(bookOwnershipDao.selectBookOwnershipByBookId(book.getId()));
        }
        return book;
    }

    public int addBook(Book book) {
        Book oldBook = bookDao.selectBookByISBN(book.getIsbn());
        if (oldBook != null) {
            throw new ResourceAlreadyExistException(book.getIsbn() + " already exist!");
        }

        return bookDao.insert(book);
    }

    public int addBookOwnership(BookOwnership ownership) {
        Book book = ownership.getBook();
        if (book.getId() == 0) {
            addBook(book);
        }
        return bookOwnershipDao.insert(ownership);
    }

    public Page<Book> search(BookPagingCriteria pagingCriteria) {
        // FIXME 迭代一先只支持ISBN搜索
        if (StringUtils.isNotBlank(pagingCriteria.getIsbn())) {
            Book book = getBookByISBN(pagingCriteria.getIsbn(), pagingCriteria.isIncludeOwnership());
            List<Book> books = new ArrayList<Book>();
            if (book != null) {
                books.add(book);
            }
            return Page.createInstance(books, books.size(), 1, 10);
        } else {
            return listBook(pagingCriteria);
        }
    }

    public Page<Book> listBook(BookPagingCriteria pagingCriteria) {
        // first get the bookownership
        Page<BookOwnership> bookOwnerships = bookOwnershipDao.listBookOwnership(pagingCriteria);

        List<Book> books = new ArrayList<Book>();
        // get the bookinfo for the ownership
        for (BookOwnership ownership : bookOwnerships.getRecords()) {
            Book book = getBookById(ownership.getBookId(), pagingCriteria.isIncludeOwnership());
            if (book == null) {
                logger.error("Can not find book by Id=" + ownership.getBookId());
            } else {
                books.add(book);
            }
        }
        return Page.createInstance(books, bookOwnerships.getRecordCount(), pagingCriteria);
    }

    /**
     * 列出我的分享
     * 
     * @param pagingCriteria
     * @return
     */
    public Page<BookOwnership> listMyBookOwnership(BookPagingCriteria pagingCriteria) {
        // first get the bookownership
        Page<BookOwnership> bookOwnerships = bookOwnershipDao.listMyBookOwnership(pagingCriteria);

        Map<Integer, Book> books = new HashMap<Integer, Book>();
        // get the bookinfo for the ownership
        for (BookOwnership ownership : bookOwnerships.getRecords()) {
            if (books.containsKey(ownership.getBook())) {
                ownership.setBook(books.get(ownership.getBookId()));
            } else {
                Book book = getBookById(ownership.getBookId(), false);
                if (book == null) {
                    logger.error("Can not find book by Id=" + ownership.getBookId());
                } else {
                    books.put(ownership.getBookId(), book);
                    ownership.setBook(book);
                }
            }
        }
        return bookOwnerships;
    }

    public boolean deleteOwnership(int id, String owner) {
        if (canManage(id, owner)) {
            return bookOwnershipDao.delete(id);
        }
        return false;
    }

    public boolean canManage(int id, String owner) {
        BookOwnership target = bookOwnershipDao.selectBookOwnershipById(id);
        if (target != null && target.getOwner().equals(owner)) {
            return true;
        }
        return false;
    }

    public boolean onShelf(int id, String owner) {
        if (canManage(id, owner)) {
            return bookOwnershipDao.updateStatus(id, BookStatus.OnShelf);
        }
        return false;
    }

    public boolean offShelf(int id, String owner) {
        if (canManage(id, owner)) {
            return bookOwnershipDao.updateStatus(id, BookStatus.OffShelf);
        }
        return false;
    }

    public boolean confirmReturn(int id, String owner) {
        if (canManage(id, owner)) {
            bookOwnershipDao.updateStatus(id, BookStatus.OnShelf);
            bookLeadingDao.updateStatus(id, BookStatus.Return);
            return true;
        }
        return false;
    }

    public boolean lead(int id, String borrower, String owner) {
        if (canManage(id, owner)) {

            bookOwnershipDao.updateStatus(id, BookStatus.Lent);

            BookLeading bookLeading = new BookLeading();
            BookOwnership bookOwnership = bookOwnershipDao.selectBookOwnershipById(id);
            bookLeading.setBookId(bookOwnership.getBookId());
            bookLeading.setBookOwnershipId(id);
            bookLeading.setBookTitle(bookOwnership.getBook().getTitle());
            bookLeading.setBorrower(borrower);
            bookLeading.setOwner(owner);
            bookLeading.setStatus(BookStatus.Lent);
            bookLeadingDao.insert(bookLeading);

            return true;
        }
        return false;
    }
}
