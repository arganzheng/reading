package me.arganzheng.project.reading.dao;

import java.util.List;

import me.arganzheng.project.reading.model.Book;

import org.springframework.stereotype.Repository;

/**
 * BookDao
 * 
 * @author arganzheng
 * @date 2013-12-18
 */
@Repository
public class BookDao extends BaseDao {

    public Book selectBookByISBN(String isbn) {
        return (Book) sqlSession.selectOne("me.arganzheng.project.reading.mapper.BookMapper.selectBookByISBN", isbn);
    }

    public List<Book> queryBook(Book book) {
        return sqlSession.selectList("me.arganzheng.project.reading.mapper.BookMapper.queryBook", book);
    }

    public int insert(Book book) {
        return sqlSession.insert("me.arganzheng.project.reading.mapper.BookMapper.insert", book);
    }

    public Book selectBookById(int id) {
        return (Book) sqlSession.selectOne("me.arganzheng.project.reading.mapper.BookMapper.selectBookById", id);

    }

    public List<Book> listBook() {
        return sqlSession.selectList("me.arganzheng.project.reading.mapper.BookMapper.listBook");
    }
}
