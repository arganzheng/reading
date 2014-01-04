package me.arganzheng.project.reading.criteria;

public class PagingCriteria {

    public static final int DEFAUT_PAGE_SIZE = 10;
    private int             pageIndex        = 1;
    private int             pageSize         = DEFAUT_PAGE_SIZE;

    public PagingCriteria(){

    }

    public PagingCriteria(int pageIndex, int pageSize){
        this.setPageIndex(pageIndex);
        this.setPageSize(pageSize);
    }

    public PagingCriteria(Integer pageIndex, Integer pageSize){
        if (pageSize == null || pageSize <= 0) {
            pageSize = DEFAUT_PAGE_SIZE;
        }
        if (pageIndex == null || pageIndex <= 0) {
            pageIndex = 1;
        }
        this.setPageIndex(pageIndex);
        this.setPageSize(pageSize);
    }

    public PagingCriteria(int pageIndex){
        this.setPageIndex(pageIndex);
    }

    public int getFromRecord() {
        return pageSize * (pageIndex - 1);
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex < 1) {
            throw new IllegalArgumentException("Invalid pageIndex: " + pageIndex);
        }

        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1 || pageSize > 20) {
            throw new IllegalArgumentException("Invalid pageSize: " + pageSize);
        }

        this.pageSize = pageSize;
    }

    public static PagingCriteria createFirstPageCriteria(PagingCriteria prototype) {
        PagingCriteria result = new PagingCriteria(1, prototype.getPageSize());
        return result;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pageIndex;
        result = prime * result + pageSize;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PagingCriteria other = (PagingCriteria) obj;
        if (pageIndex != other.pageIndex) return false;
        if (pageSize != other.pageSize) return false;
        return true;
    }

    @Override
    public String toString() {
        return "PagingCriteria [pageIndex=" + pageIndex + ", pageSize=" + pageSize + "]";
    }

}
