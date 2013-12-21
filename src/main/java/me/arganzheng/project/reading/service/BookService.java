package me.arganzheng.project.reading.service;

import java.util.List;

import me.arganzheng.project.reading.dao.BookDao;
import me.arganzheng.project.reading.dao.BookOwnershipDao;
import me.arganzheng.project.reading.exception.ResourceAlreadyExistException;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.model.BookOwnership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author arganzheng
 * @date 2013-12-14
 */
@Service
public class BookService {

    @Autowired
    private BookDao          bookDao;
    @Autowired
    private BookOwnershipDao bookOwnershipDao;

    public Book getBookById(int id, boolean includeOwnership) {
        Book book = bookDao.selectBookById(id);
        if (includeOwnership) {
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

    public List<Book> search(String searchText, boolean includeOwnership) {
        return null;
    }

    public int addBookOwnership(BookOwnership ownership) {
        Book book = ownership.getBook();
        if (book.getId() == 0) {
            addBook(book);
        }
        return bookOwnershipDao.insert(ownership);
    }

}
