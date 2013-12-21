package me.arganzheng.project.reading.dao;

import java.util.List;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.model.BookOwnership;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

/**
 * TODO 类实现描述
 * 
 * @author arganzheng
 * @date 2013-12-21
 */
public class BookOwnershipDaoTest extends BaseSpringTestCase {

    @Autowired
    private BookOwnershipDao bookOwnershipDao;
    @Autowired
    private BookDao          bookDao;

    @Test
    public void testSelectBookByISBN() {
        List<BookOwnership> bookOwnerships = bookOwnershipDao.selectBookOwnershipByBookId(5);
        Assert.notEmpty(bookOwnerships);
        System.out.println(bookOwnerships);
    }

    @Test
    @Rollback(false)
    public void testInsert() {
        String isbn = "9787505715660";
        Book book = bookDao.selectBookByISBN(isbn);
        Assert.notNull(book);

        BookOwnership bookOwnership = new BookOwnership();
        bookOwnership.setBook(book);
        bookOwnership.setUsername("guocaili");

        int id = bookOwnershipDao.insert(bookOwnership);
        Assert.isTrue(id > 0);

    }
}
