package me.arganzheng.project.reading.dao;

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

    public int insert(Book book) {
        return sqlSession.insert("me.arganzheng.project.reading.mapper.BookMapper.insert", book);
    }
}
