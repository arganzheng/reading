package me.arganzheng.project.reading.controller;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.constants.BookStatus;
import me.arganzheng.project.reading.criteria.BookPagingCriteria;
import me.arganzheng.project.reading.facade.BookFacade;
import me.arganzheng.project.reading.gateway.BookGateway;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookGateway bookGateway;

    @Autowired
    private BookFacade  bookFacade;

    /**
     * <pre>
     * 根据 书名、作者、ISBN查询，默认是按照上架时间倒序。 
     * TODO 迭代一只支持ISBN查询。
     * 
     * </pre>
     * 
     * @return
     */
    @RequestMapping("/book")
    public String search(BookPagingCriteria pagingCriteria, Model model) {
        Page<Book> books = Page.emptyPage();
        pagingCriteria.setIncludeOwnership(true);
        pagingCriteria.setStatusSet(new BookStatus[] { BookStatus.OnShelf, BookStatus.Lent, BookStatus.Return });
        books = bookService.search(pagingCriteria);

        model.addAttribute("pagingCriteria", pagingCriteria);
        model.addAttribute("books", books);
        return "list";
    }

    @RequestMapping(value = "/book/{id}")
    public String detail(@PathVariable
    Integer id, Model model) {
        Book book = bookService.getBookById(id, true);
        model.addAttribute("book", book);
        return "detail";
    }
}
