package me.arganzheng.project.reading.facade;

import java.io.IOException;

import me.arganzheng.project.reading.exception.ResourceNotFoundException;
import me.arganzheng.project.reading.gateway.BookGateway;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.model.BookOwnership;
import me.arganzheng.project.reading.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 协调Service，提供粗粒度的接口。无事务。
 * 
 * @author arganzheng
 * @date 2013-12-18
 */
@Service
public class BookFacade {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookGateway bookGateway;

    public Book searchByISBN(String isbn) {
        return searchByISBN(isbn, true);
    }

    public Book searchByISBN(String isbn, boolean includeOwnership) {
        // search local DB to see if some has already share this book
        Book book = bookService.getBookByISBN(isbn, includeOwnership);
        // if not, search the Douban
        if (book == null) {
            try {
                book = bookGateway.getBookByISBN(isbn);
            } catch (IOException e) {
                throw new RuntimeException("Call Douban API get Book Info Failed!", e);
            }
        }
        return book;
    }

    public boolean shareBook(String isbn, String username) {
        Book book = searchByISBN(isbn, false);

        if (book == null) {
            throw new ResourceNotFoundException("Can not book with isbn: " + isbn);
        }

        BookOwnership ownership = new BookOwnership();
        ownership.setBook(book);
        ownership.setOwner(username);

        int id = bookService.addBookOwnership(ownership);

        return id > 0 ? true : false;
    }
}
