package me.arganzheng.project.reading.service;

import me.arganzheng.project.reading.dao.BookDao;
import me.arganzheng.project.reading.exception.ResourceAlreadyExistException;
import me.arganzheng.project.reading.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author arganzheng
 * @date 2013-12-14
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Book getBookByISBN(String isbn) {
        return bookDao.selectBookByISBN(isbn);
    }

    public int addBook(Book book) {
        Book oldBook = bookDao.selectBookByISBN(book.getIsbn());
        if (oldBook != null) {
            throw new ResourceAlreadyExistException(book.getIsbn() + " already exist!");
        }
        return bookDao.insert(book);
    }
}
