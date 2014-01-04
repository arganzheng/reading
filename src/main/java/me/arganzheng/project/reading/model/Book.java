package me.arganzheng.project.reading.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @author arganzheng
 * @date 2013-12-14
 */
public class Book {

    private static final int    MAX_SUMMARY_LENGTH = 1000;
    private int                 id;
    private Date                createdTime;
    private Date                modifiedTime;

    private String              isbn10;
    private String              isbn13;

    private String              title;
    private String              subtitle;

    private String              image;

    private List<String>        authors;
    private Date                pubdate;
    private String              summary;
    private String              pageCount;

    private List<String>        tags;

    private String              detailLink;

    private List<String>        owners;

    // One books may be owned by many user, refer to book_owner_ship table
    private List<BookOwnership> ownerships;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn() {
        // 优先返回isbn13
        if (StringUtils.isNotEmpty(isbn13)) {
            return isbn13;
        } else {
            return isbn10;
        }
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        // summary截断保存1k
        if (summary.length() > MAX_SUMMARY_LENGTH) {
            this.summary = summary.substring(0, MAX_SUMMARY_LENGTH - 3) + "...";
        } else {
            this.summary = summary;
        }
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDetailLink() {
        return detailLink;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }

    public List<String> getOwners() {
        return owners;
    }

    public void setOwners(List<String> owners) {
        this.owners = owners;
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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<BookOwnership> getOwnerships() {
        return ownerships;
    }

    public void setOwnerships(List<BookOwnership> ownerships) {
        this.ownerships = ownerships;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", isbn10="
               + isbn10 + ", isbn13=" + isbn13 + ", title=" + title + ", subtitle=" + subtitle + ", image=" + image
               + ", authors=" + authors + ", pubdate=" + pubdate + ", summary=" + summary + ", pageCount=" + pageCount
               + ", tags=" + tags + ", detailLink=" + detailLink + ", owners=" + owners + ", ownerships=" + ownerships
               + "]";
    }

}
