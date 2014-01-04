package me.arganzheng.project.reading.criteria;

import java.util.HashSet;
import java.util.Set;

import me.arganzheng.project.reading.constants.BookStatus;

/**
 * 图书查询对象
 */
public class BookPagingCriteria extends PagingCriteria {

    private String          isbn;
    private String          author;
    private String          name;

    private String          owner;

    private boolean         includeOwnership;

    private Set<BookStatus> statusSet = new HashSet<BookStatus>();

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIncludeOwnership() {
        return includeOwnership;
    }

    public void setIncludeOwnership(boolean includeOwnership) {
        this.includeOwnership = includeOwnership;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Set<BookStatus> getStatusSet() {
        return statusSet;
    }

    public void setStatusSet(Set<BookStatus> statusSet) {
        this.statusSet = statusSet;
    }

    public void addStatus(BookStatus status) {
        this.statusSet.add(status);
    }

    public void setStatusSet(BookStatus... statusList) {
        for (BookStatus status : statusList) {
            this.statusSet.add(status);
        }
    }
}
