package me.arganzheng.project.reading.lucene;

import java.util.List;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.constants.BookStatus;
import me.arganzheng.project.reading.criteria.BookPagingCriteria;
import me.arganzheng.project.reading.criteria.PagingCriteria;
import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDataProvider implements DataProvider {

    @Autowired
    private BookService bookService;

    @Override
    public List<Book> fetchData() {
        BookPagingCriteria pagingCriteria = new BookPagingCriteria();
        pagingCriteria.setIncludeOwnership(false);
        pagingCriteria.setStatusSet(BookStatus.OnShelf, BookStatus.Lent, BookStatus.Return);
        Page<Book> books = bookService.listBook(pagingCriteria);

        return books.getRecords();
    }

    @Override
    public int getFetchSize() {
        return PagingCriteria.DEFAUT_PAGE_SIZE;
    }

}
