package me.arganzheng.project.reading.controller;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.common.WebUser;
import me.arganzheng.project.reading.criteria.BookLeadingPagingCriteria;
import me.arganzheng.project.reading.criteria.BookPagingCriteria;
import me.arganzheng.project.reading.facade.BookFacade;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.model.BookLeading;
import me.arganzheng.project.reading.model.BookOwnership;
import me.arganzheng.project.reading.service.BookService;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/my")
public class MyController {

    public static final Logger logger = Logger.getLogger(MyController.class);

    @Autowired
    private BookFacade         bookFacade;

    @Autowired
    private BookService        bookService;

    @Autowired
    private WebUser            user;

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

        return "redirect:/book";
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String myBooks(@RequestParam(value = "pageIndex", required = false)
    Integer pageIndex, @RequestParam(value = "pageSize", required = false)
    Integer pageSize, Model model) {
        if (pageIndex == null || pageIndex.intValue() == 0) {
            pageIndex = 1;
        }
        if (pageSize == null || pageSize.intValue() < 1 || pageSize.intValue() > 20) {
            pageSize = 10;
        }

        BookPagingCriteria bookPagingCriteria = new BookPagingCriteria();
        bookPagingCriteria.setOwner(user.getUsername());
        bookPagingCriteria.setPageIndex(pageIndex);
        bookPagingCriteria.setPageSize(pageSize);
        bookPagingCriteria.setIncludeOwnership(false);
        Page<BookOwnership> myBookOwnerships = bookService.listMyBookOwnership(bookPagingCriteria);

        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("myBookOwnerships", myBookOwnerships);

        return "my_book";
    }

    /**
     * 我的借出
     */
    @RequestMapping(value = "/sharing", method = RequestMethod.GET)
    public String mySharing(@RequestParam(value = "pageIndex", required = false)
    Integer pageIndex, @RequestParam(value = "pageSize", required = false)
    Integer pageSize, Model model) {
        if (pageIndex == null || pageIndex.intValue() == 0) {
            pageIndex = 1;
        }
        if (pageSize == null || pageSize.intValue() < 1 || pageSize.intValue() > 20) {
            pageSize = 10;
        }

        BookLeadingPagingCriteria paginCriteria = new BookLeadingPagingCriteria();
        paginCriteria.setOwner(user.getUsername());
        paginCriteria.setPageIndex(pageIndex);
        paginCriteria.setPageSize(pageSize);
        Page<BookLeading> mySharing = bookService.listMyBookSharing(paginCriteria);

        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("mySharing", mySharing);

        return "my_sharing";
    }

    /**
     * 我的借阅
     */
    @RequestMapping(value = "/reading", method = RequestMethod.GET)
    public String myReading(@RequestParam(value = "pageIndex", required = false)
    Integer pageIndex, @RequestParam(value = "pageSize", required = false)
    Integer pageSize, Model model) {
        if (pageIndex == null || pageIndex.intValue() == 0) {
            pageIndex = 1;
        }
        if (pageSize == null || pageSize.intValue() < 1 || pageSize.intValue() > 20) {
            pageSize = 10;
        }

        BookLeadingPagingCriteria paginCriteria = new BookLeadingPagingCriteria();
        paginCriteria.setBorrower(user.getUsername());
        paginCriteria.setPageIndex(pageIndex);
        paginCriteria.setPageSize(pageSize);
        Page<BookLeading> myReading = bookService.listMyBookSharing(paginCriteria);

        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("myReading", myReading);

        return "my_reading";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteOwnership(@PathVariable("id")
    int id) {
        return bookService.deleteOwnership(id, user.getUsername());
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.POST)
    @ResponseBody
    public boolean handleOwnershipAction(@PathVariable("id")
    int id, @RequestParam("action")
    String action, @RequestParam(value = "borrower", required = false)
    String borrower) {
        if (StringUtils.equalsIgnoreCase("onShelf", action)) {
            return bookService.onShelf(id, user.getUsername());
        } else if (StringUtils.equalsIgnoreCase("offShelf", action)) {
            return bookService.offShelf(id, user.getUsername());
        } else if (StringUtils.equalsIgnoreCase("confirmReturn", action)) {
            return bookService.confirmReturn(id, user.getUsername());
        } else if ((StringUtils.equalsIgnoreCase("lead", action))) {
            return bookService.lead(id, borrower, user.getUsername());
        } else {
            logger.error("unsupported action! action=" + action);
            return false;
        }
    }

}
