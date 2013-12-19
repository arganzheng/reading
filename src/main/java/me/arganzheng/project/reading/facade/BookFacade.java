package me.arganzheng.project.reading.facade;

import me.arganzheng.project.reading.gateway.BookGateway;
import me.arganzheng.project.reading.model.Book;
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
        // search local DB to see if some has already share this book
        Book book = bookService.getBookByISBN(isbn);
        // if not, search the Douban
        if (book == null) {
            book = bookGateway.getBookByISBN(isbn);
        }
        return book;
    }
}
