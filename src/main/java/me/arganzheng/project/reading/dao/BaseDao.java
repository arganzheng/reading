package me.arganzheng.project.reading.dao;

import java.util.List;

import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.common.PagingCriteria;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDao extends SqlMapClientDaoSupport {

    public static final int MAX_BATCH_SIZE = 10000;
    protected Logger        logger         = Logger.getLogger(getClass());

    @Autowired
    @Qualifier("sqlMapClient")
    public void setSqlMapClientWorkaround(SqlMapClient sqlMapClient) {
        this.setSqlMapClient(sqlMapClient);
    }

    /**
     * @param countStatementName
     * @param queryStatementName
     * @param query
     * @author arganzheng
     * @return 分页结果
     */
    protected Page queryForPagination(String countStatementName, String queryStatementName,
                                      PagingCriteria pagingCriteria) {
        int totalCount = ((Integer) getSqlMapClientTemplate().queryForObject(countStatementName, pagingCriteria)).intValue();

        if (totalCount > 0) {
            List items = getSqlMapClientTemplate().queryForList(queryStatementName, pagingCriteria);

            if (items != null && !items.isEmpty()) {
                return Page.createInstance(items, totalCount, pagingCriteria);
            }
        }

        return Page.emptyPage();
    }
}
