package me.arganzheng.project.reading.controller;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.criteria.BookPagingCriteria;
import me.arganzheng.project.reading.facade.BookFacade;
import me.arganzheng.project.reading.gateway.BookGateway;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    String searchText, @RequestParam(value = "pageIndex", required = false)
    Integer pageIndex, @RequestParam(value = "pageSize", required = false)
    Integer pageSize, Model model) {
        if (pageIndex == null || pageIndex.intValue() == 0) {
            pageIndex = 1;
        }
        if (pageSize == null || pageSize.intValue() < 1 || pageSize.intValue() > 20) {
            pageSize = 10;
        }

        Page<Book> books = Page.emptyPage();

        BookPagingCriteria bookPagingCriteria = new BookPagingCriteria();
        bookPagingCriteria.setIsbn(searchText);
        bookPagingCriteria.setPageIndex(pageIndex);
        bookPagingCriteria.setPageSize(pageSize);
        bookPagingCriteria.setIncludeOwnership(true);
        books = bookService.search(bookPagingCriteria);

        model.addAttribute("q", searchText);
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("books", books);
        return "list";
    }
}
