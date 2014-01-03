package me.arganzheng.project.reading.model;

import java.util.Date;

import me.arganzheng.project.reading.constants.BookStatus;

/**
 * 图书借阅关系
 * 
 * @author arganzheng
 * @date 2014-1-3
 */
public class BookLeading {

    private int        id;
    private Date       createdTime;
    private Date       modifiedTime;
    private String     borrower;
    private Date       borrowTime;
    private Date       returnTime;
    private BookStatus status = BookStatus.Lent;
    private String     owner;
    private String     bookTitle;
    private int        bookId;
    private int        bookOwnershipId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookOwnershipId() {
        return bookOwnershipId;
    }

    public void setBookOwnershipId(int bookOwnershipId) {
        this.bookOwnershipId = bookOwnershipId;
    }

}
