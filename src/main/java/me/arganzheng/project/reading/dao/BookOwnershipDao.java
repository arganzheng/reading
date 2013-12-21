package me.arganzheng.project.reading.dao;

import java.util.List;

import me.arganzheng.project.reading.model.BookOwnership;

import org.springframework.stereotype.Repository;

/**
 * BookOwnershipDao
 * 
 * @author arganzheng
 * @date 2013-12-21
 */
@Repository
public class BookOwnershipDao extends BaseDao {

    public List<BookOwnership> selectBookOwnershipByBookId(int bookId) {
        return sqlSession.selectList("me.arganzheng.project.reading.mapper.BookOwnershipMapper.selectBookOwnershipByBookId",
                                     bookId);
    }

    public int insert(BookOwnership bookOwnership) {
        return sqlSession.insert("me.arganzheng.project.reading.mapper.BookOwnershipMapper.insert", bookOwnership);
    }
}
