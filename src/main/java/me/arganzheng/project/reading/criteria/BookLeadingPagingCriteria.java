package me.arganzheng.project.reading.criteria;

import me.arganzheng.project.reading.constants.BookStatus;

public class BookLeadingPagingCriteria extends PagingCriteria {

    private Integer    bookOwnershipId;

    private String     owner;
    private String     borrower;
    private BookStatus status;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Integer getBookOwnershipId() {
        return bookOwnershipId;
    }

    public void setBookOwnershipId(Integer bookOwnershipId) {
        this.bookOwnershipId = bookOwnershipId;
    }

}
