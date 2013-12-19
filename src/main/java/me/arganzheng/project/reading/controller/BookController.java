package me.arganzheng.project.reading.controller;

import me.arganzheng.project.reading.facade.BookFacade;
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

    @Autowired
    private BookFacade  bookFacade;

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    public Book searchByISBN(@PathVariable
    String isbn) {
        Book book = bookFacade.searchByISBN(isbn);
        return book;
    }
}
