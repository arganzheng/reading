package me.arganzheng.project.reading.model;

import java.util.Date;

import me.arganzheng.project.reading.constants.BookStatus;

/**
 * 书籍的拥有关系
 * 
 * @author arganzheng
 * @date 2013-12-14
 */
public class BookOwnership {

    private int        id;
    private Date       createdTime;
    private Date       modifiedTime;

    private String     owner;
    // Book:BookOwnerShip=1:N
    private Book       book;

    // 默认上架
    private BookStatus status = BookStatus.OnShelf;

    public String getOwner() {
        return owner;
    }

    public int getBookId() {
        return book == null ? 0 : book.getId();
    }

    public String getBookTitle() {
        return book == null ? null : book.getTitle();
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookOwnership [id=" + id + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime
               + ", owner=" + owner + ", book=" + book + ", status=" + status + "]";
    }

}
