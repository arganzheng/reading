package me.arganzheng.project.reading.geteway;

import java.io.IOException;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.gateway.BookGateway;
import me.arganzheng.project.reading.model.Book;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author arganzheng
 * @date 2013-12-28
 */
public class BookGatewayTest extends BaseSpringTestCase {

    @Autowired
    BookGateway gateway;

    @Test
    public void testGetBookByISBN() throws IOException {
        String isbn = "";
        Book book = gateway.getBookByISBN(isbn);
        Assert.notNull(book);
    }
}
