package me.arganzheng.project.reading.dao;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.model.User;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class TestUserDao extends BaseSpringTestCase {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectUserByUsernameWithDao() {
        User user = userDao.selectUserByUsername("arganzheng");
        Assert.notNull(user);

    }
}
