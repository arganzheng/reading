package me.arganzheng.project.reading.dao;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.criteria.BookLeadingPagingCriteria;
import me.arganzheng.project.reading.model.BookLeading;

import org.springframework.stereotype.Repository;

/**
 * 借阅关系DAO
 * 
 * @author arganzheng
 * @date 2014-1-3
 */
@Repository
public class BookLeadingDao extends BaseDao {

    @SuppressWarnings("unchecked")
    public Page<BookLeading> listMyBookLeading(BookLeadingPagingCriteria pagingCriteria) {
        return queryForPagination("me.arganzheng.project.reading.mapper.BookLeadingMapper.listMyBookLeading",
                                  "me.arganzheng.project.reading.mapper.BookLeadingMapper.countMyBookLeading",
                                  pagingCriteria);
    }

    public int insert(BookLeading bookOwnership) {
        return sqlSession.insert("me.arganzheng.project.reading.mapper.BookLeadingMapper.insert", bookOwnership);
    }

    public boolean confirmReturn(int bookOwnershipId) {
        int count = sqlSession.update("me.arganzheng.project.reading.mapper.BookLeadingMapper.confirmReturn",
                                      bookOwnershipId);
        return count == 1 ? true : false;
    }

}
