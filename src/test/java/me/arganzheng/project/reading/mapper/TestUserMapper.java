package me.arganzheng.project.reading.mapper;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.model.User;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class TestUserMapper extends BaseSpringTestCase {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUserByUsername() {
        User user = userMapper.selectUserByUsername("arganzheng");
        Assert.notNull(user);
    }

}
