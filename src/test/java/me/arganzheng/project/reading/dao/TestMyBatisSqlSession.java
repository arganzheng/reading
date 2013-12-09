package me.arganzheng.project.reading.dao;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.model.User;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class TestMyBatisSqlSession extends BaseSpringTestCase {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testSelectUserByUsernameWithDao() {
        User user = (User) sqlSession.selectOne("me.arganzheng.project.reading.mapper.UserMapper.selectUserByUsername",
                                                "arganzheng");
        Assert.notNull(user);
    }
}
