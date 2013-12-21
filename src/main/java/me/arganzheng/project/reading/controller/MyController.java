package me.arganzheng.project.reading.controller;

import me.arganzheng.project.reading.common.WebUser;
import me.arganzheng.project.reading.facade.BookFacade;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.service.BookService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my")
public class MyController {

    @Autowired
    private BookFacade  bookFacade;

    @Autowired
    private BookService bookService;

    @Autowired
    private WebUser     user;

    @RequestMapping(value = "/account/login", method = RequestMethod.GET)
    public String login() {
        return "index";
    }

    @RequestMapping(value = "/book/share", method = RequestMethod.GET)
    public String sharePage(@RequestParam(required = false)
    String isbn, Model model) {
        if (StringUtils.isNotEmpty(isbn)) {
            Book book = bookFacade.searchByISBN(isbn);
            model.addAttribute("book", book);
        }
        model.addAttribute("isbn", isbn);

        return "share";
    }

    @RequestMapping(value = "/book/share", method = RequestMethod.POST)
    public String share(@RequestParam(value = "isbn")
    String isbn, @RequestParam(value = "bookId")
    int bookId) {
        bookFacade.shareBook(isbn, user.getUsername());

        return "index";
    }
}
