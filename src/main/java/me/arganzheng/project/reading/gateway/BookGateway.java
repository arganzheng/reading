package me.arganzheng.project.reading.gateway;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.util.ConfigurationTool;
import me.arganzheng.project.reading.util.WebUtils;

import org.springframework.stereotype.Component;

/**
 * API查询网关
 * 
 * @author arganzheng
 * @date 2013-12-14
 */
@Component
public class BookGateway {

    private static final String API_URL = "https://api.douban.com/v2/book/isbn/";

    /**
     * 调用Douban API获取图书信息
     * 
     * @param isbn
     * @return
     */
    public Book getBookByISBN(String isbn) throws IOException {
        String url = API_URL + isbn;

        String proxyIp = ConfigurationTool.getProperty("proxyIp");
        int proxyPort = Integer.parseInt(ConfigurationTool.getProperty("proxyPort"));
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyIp, proxyPort));
        String bookJson = WebUtils.doGet(url, null, proxy);
        System.out.println(bookJson);

        Book book = jsonToBook(bookJson);
        return book;
    }

    private Book jsonToBook(String bookJson) {
        // TODO Auto-generated method stub
        return null;
    }

}
