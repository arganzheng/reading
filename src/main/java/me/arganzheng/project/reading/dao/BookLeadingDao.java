package me.arganzheng.project.reading.dao;

import java.util.List;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.constants.BookStatus;
import me.arganzheng.project.reading.criteria.BookPagingCriteria;
import me.arganzheng.project.reading.criteria.PagingCriteria;
import me.arganzheng.project.reading.model.BookLeading;
import me.arganzheng.project.reading.util.IBatisParameterMap;

import org.springframework.stereotype.Repository;

/**
 * 借阅关系DAO
 * 
 * @author arganzheng
 * @date 2014-1-3
 */
@Repository
public class BookLeadingDao extends BaseDao {

    public BookLeading selectBookLeadingById(int id) {
        return sqlSession.selectOne("me.arganzheng.project.reading.mapper.BookLeadingMapper.selectBookLeadingById", id);
    }

    public List<BookLeading> selectBookLeadingByBookId(int bookId) {
        return sqlSession.selectList("me.arganzheng.project.reading.mapper.BookLeadingMapper.selectBookLeadingByBookId",
                                     bookId);
    }

    @SuppressWarnings("unchecked")
    public Page<BookLeading> listBookLeading(PagingCriteria pagingCriteria) {
        return queryForPagination("me.arganzheng.project.reading.mapper.BookLeadingMapper.listBookLeading",
                                  "me.arganzheng.project.reading.mapper.BookLeadingMapper.countBookLeading",
                                  pagingCriteria);
    }

    @SuppressWarnings("unchecked")
    public Page<BookLeading> listMyBookLeading(BookPagingCriteria pagingCriteria) {
        return queryForPagination("me.arganzheng.project.reading.mapper.BookLeadingMapper.listMyBookLeading",
                                  "me.arganzheng.project.reading.mapper.BookLeadingMapper.countMyBookLeading",
                                  pagingCriteria);
    }

    public int insert(BookLeading bookOwnership) {
        return sqlSession.insert("me.arganzheng.project.reading.mapper.BookLeadingMapper.insert", bookOwnership);
    }

    public boolean delete(int id) {
        int count = sqlSession.delete("me.arganzheng.project.reading.mapper.BookLeadingMapper.delete", id);
        return count == 1 ? true : false;
    }

    public boolean updateStatus(int bookOwnershipId, BookStatus status) {
        IBatisParameterMap params = new IBatisParameterMap();
        params.put("bookOwnershipId", bookOwnershipId);
        params.put("status", status);
        int count = sqlSession.update("me.arganzheng.project.reading.mapper.BookLeadingMapper.updateStatus", params);
        return count == 1 ? true : false;
    }

}
