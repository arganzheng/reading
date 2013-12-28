package me.arganzheng.project.reading.gateway;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.arganzheng.project.reading.model.Book;
import me.arganzheng.project.reading.util.ConfigurationTool;
import me.arganzheng.project.reading.util.WebUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

/**
 * API查询网关
 * 
 * @author arganzheng
 * @date 2013-12-14
 */
@Component
public class BookGateway {

    private static final Logger logger  = Logger.getLogger(BookGateway.class);

    private static Proxy        proxy   = null;
    static {
        String proxyIp = ConfigurationTool.getProperty("proxyIp");
        int proxyPort = Integer.parseInt(ConfigurationTool.getProperty("proxyPort"));
        if (StringUtils.isEmpty(proxyIp)) { // proxy set
            proxy = null;
        } else {
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyIp, proxyPort));
            logger.info("Proxy Set to [" + proxy.toString() + "]");
        }
    }

    private static final String API_URL = "https://api.douban.com/v2/book/isbn/";

    /**
     * 调用Douban API获取图书信息
     * 
     * @param isbn
     * @return
     */
    public Book getBookByISBN(String isbn) throws IOException {
        String url = API_URL + isbn;

        String bookJson = WebUtils.doGet(url, null, proxy);
        System.out.println(bookJson);

        Book book = jsonToBook(bookJson);
        return book;
    }

    private Book jsonToBook(String bookJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map bookMap = mapper.readValue(bookJson, Map.class);
            Book book = new Book();
            book.setIsbn10((String) bookMap.get("isbn10"));
            book.setIsbn13((String) bookMap.get("isbn13"));
            book.setTitle((String) bookMap.get("title"));
            book.setSubtitle(StringUtils.trimToNull((String) bookMap.get("subtitle")));
            book.setImage((String) bookMap.get("image"));
            String pageCount = (String) bookMap.get("pages");
            if (StringUtils.isNotEmpty(pageCount)) {
                book.setPageCount(Integer.valueOf(pageCount));
            }
            book.setPubdate(DateUtils.parseDate((String) bookMap.get("pubdate"), new String[] { "yyyy-MM-dd",
                    "yyyy-MM", "yyyy.MM" }));
            book.setSummary((String) bookMap.get("summary"));
            book.setAuthors((List) bookMap.get("author"));
            List<Map> tagList = (List<Map>) bookMap.get("tags");
            List<String> tags = new ArrayList<String>();
            for (Map e : tagList) {
                tags.add((String) e.get("name"));
            }
            book.setTags(tags);
            book.setDetailLink((String) bookMap.get("alt"));
            return book;
        } catch (Exception e) {
            logger.error("parse json to object failed!", e);
            throw new IOException(e);
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        String url = API_URL + "7505715666";
        String bookJson = WebUtils.doGet(url, null, proxy);
        System.out.println(bookJson);
        ObjectMapper mapper = new ObjectMapper();
        Map bookMap = mapper.readValue(bookJson, Map.class);
        Book book = new Book();
        book.setIsbn10((String) bookMap.get("isbn10"));
        book.setIsbn13((String) bookMap.get("isbn13"));
        book.setTitle((String) bookMap.get("title"));
        book.setSubtitle((String) bookMap.get("subtitle"));
        book.setImage((String) bookMap.get("image"));
        book.setPageCount(Integer.parseInt((String) bookMap.get("pages")));
        book.setPubdate(DateUtils.parseDate((String) bookMap.get("pubdate"), new String[] { "yyyy-MM-dd" }));
        book.setSummary((String) bookMap.get("summary"));
        book.setAuthors((List) bookMap.get("author"));
        List<Map> tagList = (List<Map>) bookMap.get("tags");
        List<String> tags = new ArrayList<String>();
        for (Map e : tagList) {
            tags.add((String) e.get("name"));
        }
        book.setTags(tags);
        book.setDetailLink((String) bookMap.get("alt"));
        System.out.println(book);
    }
}
