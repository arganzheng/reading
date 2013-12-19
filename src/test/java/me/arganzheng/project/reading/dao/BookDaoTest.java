package me.arganzheng.project.reading.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.model.Book;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

/**
 * TODO 类实现描述
 * 
 * @author arganzheng
 * @date 2013-12-18
 */
public class BookDaoTest extends BaseSpringTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testSelectBookByISBN() {
        String isbn = "isbn10";
        Book book = bookDao.selectBookByISBN(isbn);
        Assert.notNull(book);

    }

    @Test
    @Rollback(false)
    public void testInsert() {
        Book book = new Book();

        book.setTitle("title");
        book.setSubtitle("subTitle");
        book.setPubdate(new Date());
        book.setDetailLink("detailLink");
        book.setImage("image");
        book.setIsbn10("isbn10");
        book.setIsbn13("isbn13");
        List<String> owners = new ArrayList<String>();
        owners.add("arganzheng");
        owners.add("magi");
        book.setOwners(owners);
        book.setIsbn13("isbn13");
        List<String> authors = new ArrayList<String>();
        authors.add("arganzheng");
        authors.add("magi");
        book.setAuthors(authors);
        book.setPageCount(1000);
        book.setSummary("summary");

        List<String> tags = new ArrayList<String>();
        tags.add("tag1");
        tags.add("tag2");
        book.setTags(tags);

        int id = bookDao.insert(book);
        Assert.isTrue(id > 0);

    }
}
