package me.arganzheng.project.reading.service;

import java.util.ArrayList;
import java.util.List;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.criteria.PagingCriteria;
import me.arganzheng.project.reading.dao.BookDao;
import me.arganzheng.project.reading.dao.BookOwnershipDao;
import me.arganzheng.project.reading.exception.ResourceAlreadyExistException;
import me.arganzheng.project.reading.model.Book;
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

    public Book getBookById(int id, boolean includeOwnership) {
        Book book = bookDao.selectBookById(id);
        if (book != null && includeOwnership) {
            book.setOwnerships(bookOwnershipDao.selectBookOwnershipByBookId(book.getId()));
        }
        return book;
    }

    public Book getBookByISBN(String isbn, boolean includeOwnership) {
        Book book = bookDao.selectBookByISBN(isbn);
        if (includeOwnership) {
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

    public List<Book> search(String searchText, boolean includeOwnership) {
        // FIXME 迭代一先只支持ISBN搜索
        if (StringUtils.isBlank(searchText)) {
            return listBook(includeOwnership);
        } else {
            Book book = getBookByISBN(searchText, includeOwnership);
            List<Book> books = new ArrayList<Book>();
            if (book != null) {
                books.add(book);
            }
            return books;
        }
    }

    public List<Book> listBook(boolean includeOwnership) {
        // first get the bookownership
        PagingCriteria pagingCriteria = new PagingCriteria();
        Page<BookOwnership> bookOwnerships = bookOwnershipDao.listBookOwnership(pagingCriteria);

        List<Book> books = new ArrayList<Book>();
        // get the bookinfo for the ownership
        for (BookOwnership ownership : bookOwnerships.getRecords()) {
            Book book = getBookById(ownership.getBookId(), includeOwnership);
            if (book == null) {
                logger.error("Can not find book by Id=" + ownership.getBookId());
            } else {
                books.add(book);
            }
        }
        return books;
    }
}
