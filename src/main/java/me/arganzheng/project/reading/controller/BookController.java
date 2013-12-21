package me.arganzheng.project.reading.controller;

import java.util.ArrayList;
import java.util.List;

import me.arganzheng.project.reading.facade.BookFacade;
import me.arganzheng.project.reading.gateway.BookGateway;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookGateway bookGateway;

    @Autowired
    private BookFacade  bookFacade;

    /**
     * 根据 书名、作者、ISBN查询，默认是安装上传时间倒叙
     * 
     * @return
     */
    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String search(@RequestParam(value = "q", required = false)
    String searchText, Model model) {
        List<Book> books = new ArrayList<Book>();
        if (StringUtils.isEmpty(searchText)) {
            books = bookService.listBook(true);
        } else {
            books = bookService.search(searchText, false);
        }

        model.addAttribute("q", searchText);
        model.addAttribute("books", books);
        return "list";
    }
}
