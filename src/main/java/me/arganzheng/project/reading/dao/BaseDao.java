package me.arganzheng.project.reading.dao;

import java.util.List;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.criteria.PagingCriteria;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 分页、批量操作在这里进行。
 * 
 * @author arganzheng
 * @date 2013-12-9
 */
public abstract class BaseDao {

    protected Logger        logger         = Logger.getLogger(getClass());

    @Autowired
    protected SqlSession    sqlSession;

    public static final int MAX_BATCH_SIZE = 10000;

    /**
     * @param countStatementName
     * @param queryStatementName
     * @param query
     * @return 分页结果
     */
    protected Page queryForPagination(String queryStatementName, String countStatementName,
                                      PagingCriteria pagingCriteria) {
        int totalCount = sqlSession.selectOne(countStatementName, pagingCriteria);

        if (totalCount > 0) {
            List items = sqlSession.selectList(queryStatementName, pagingCriteria);

            if (items != null && !items.isEmpty()) {
                return Page.createInstance(items, totalCount, pagingCriteria);
            }
        }

        return Page.emptyPage();
    }

    /**
     * <pre>
     * 返回Mapper。如：
     * 
     *   BlogMapper mapper = session.getMapper(BlogMapper.class); 
     *   Blog blog = mapper.selectBlog(101);
     * </pre>
     * 
     * @param clazz
     * @return
     */
    protected <T> T getMapper(Class<T> clazz) {
        return sqlSession.getMapper(clazz);
    }
}
