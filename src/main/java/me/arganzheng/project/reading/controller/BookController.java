package me.arganzheng.project.reading.controller;

import me.arganzheng.project.reading.gateway.BookGateway;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookGateway bookGateway;

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    public Book searchByISBN(@PathVariable
    String isbn) {
        // search local DB to see if some has already share this book
        Book book = bookService.getBookByISBN(isbn);
        // if not, search the Douban
        if (book == null) {
            book = bookGateway.getBookByISBN(isbn);
        }
        return book;
    }
}
