package me.arganzheng.project.reading.gateway;

import me.arganzheng.project.reading.model.Book;

import org.springframework.stereotype.Component;

/**
 * API查询网关
 * 
 * @author arganzheng
 * @date 2013-12-14
 */
@Component
public class BookGateway {

    /**
     * 调用Douban API获取图书信息
     * 
     * @param isbn
     * @return
     */
    public Book getBookByISBN(String isbn) {
        // TODO Auto-generated method stub
        return null;
    }

}
