package me.arganzheng.project.reading.criteria;

public class BookPagingCriteria extends PagingCriteria {

    private String  isbn;
    private String  author;
    private String  name;

    private String  owner;

    private boolean includeOwnership;

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

}
