package me.arganzheng.project.reading.model;

import me.arganzheng.project.reading.constants.BookStatus;

/**
 * 书籍的拥有关系
 * 
 * @author arganzheng
 * @date 2013-12-14
 */
public class BookOwnership {

    private String     username;

    private Book       book;

    private BookStatus status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
