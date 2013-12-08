package me.arganzheng.project.reading.dao;

import me.arganzheng.project.reading.ReadingTestBase;
import me.arganzheng.project.reading.mapper.UserMapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestMybatisDao extends ReadingTestBase {

    @Autowired
    UserMapper userDao;

    @Test
    public void test() {
        System.out.println(userDao.selectUserByUsername("arganzheng"));
    }
}
