package me.arganzheng.project.reading.lucene;

import java.util.List;

public interface DataProvider {

    public <T> List<T> fetchData();

    public int getFetchSize();

    // public int getTotalCount();

}
