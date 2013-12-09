package me.arganzheng.project.reading.dao;

import me.arganzheng.project.reading.model.Account;

import org.springframework.stereotype.Repository;

/**
 * <pre>
 * 使用SqlSession接口达到ibatis的使用效果 
 * @see http://mybatis.github.io/spring/zh/sqlsession.html
 * 
 * </pre>
 * 
 * @author arganzheng
 * @date 2013-12-09
 */
@Repository
public class AccountDao extends BaseDao {

    public Account selectAccountByName(String name) {
        return (Account) sqlSession.selectOne("me.arganzheng.project.reading.mapper.AccountMapper.selectAccountByName",
                                              name);
    }
}
