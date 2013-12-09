package me.arganzheng.project.reading.dao;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.model.Account;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class MyBatisSqlSessionTest extends BaseSpringTestCase {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testSelectUserByUsernameWithDao() {
        Account user = (Account) sqlSession.selectOne("me.arganzheng.project.reading.mapper.AccountMapper.selectAccountByName",
                                                      "arganzheng");
        Assert.notNull(user);
    }
}
