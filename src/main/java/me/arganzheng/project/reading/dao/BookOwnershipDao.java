package me.arganzheng.project.reading.dao;

import java.util.List;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.criteria.BookPagingCriteria;
import me.arganzheng.project.reading.criteria.PagingCriteria;
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

    public BookOwnership selectBookOwnershipById(int id) {
        return sqlSession.selectOne("me.arganzheng.project.reading.mapper.BookOwnershipMapper.selectBookOwnershipById",
                                    id);
    }

    public List<BookOwnership> selectBookOwnershipByBookId(int bookId) {
        return sqlSession.selectList("me.arganzheng.project.reading.mapper.BookOwnershipMapper.selectBookOwnershipByBookId",
                                     bookId);
    }

    @SuppressWarnings("unchecked")
    public Page<BookOwnership> listBookOwnership(PagingCriteria pagingCriteria) {
        return queryForPagination("me.arganzheng.project.reading.mapper.BookOwnershipMapper.listBookOwnership",
                                  "me.arganzheng.project.reading.mapper.BookOwnershipMapper.countBookOwnership",
                                  pagingCriteria);
    }

    @SuppressWarnings("unchecked")
    public Page<BookOwnership> listMyBookOwnership(BookPagingCriteria pagingCriteria) {
        return queryForPagination("me.arganzheng.project.reading.mapper.BookOwnershipMapper.listMyBookOwnership",
                                  "me.arganzheng.project.reading.mapper.BookOwnershipMapper.countMyBookOwnership",
                                  pagingCriteria);
    }

    public int insert(BookOwnership bookOwnership) {
        return sqlSession.insert("me.arganzheng.project.reading.mapper.BookOwnershipMapper.insert", bookOwnership);
    }

    public boolean delete(int id) {
        int count = sqlSession.delete("me.arganzheng.project.reading.mapper.BookOwnershipMapper.delete", id);
        return count == 1 ? true : false;
    }

}
