package me.arganzheng.project.reading.service;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.criteria.BookLeadingPagingCriteria;
import me.arganzheng.project.reading.model.BookLeading;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceTest extends BaseSpringTestCase {

    @Autowired
    private BookService bookService;

    @Test
    public void testListMyBookSharing() {
        BookLeadingPagingCriteria pagingCriteria = new BookLeadingPagingCriteria();
        pagingCriteria.setBorrower("arganzheng");
        Page<BookLeading> myBookSharing = bookService.listMyBookSharing(pagingCriteria);
        System.out.println(myBookSharing.getRecordCount());
    }
}
