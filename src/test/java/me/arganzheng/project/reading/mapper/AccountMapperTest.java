package me.arganzheng.project.reading.mapper;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.model.Account;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class AccountMapperTest extends BaseSpringTestCase {

    @Autowired
    private AccountMapper userMapper;

    @Test
    public void testSelectUserByUsername() {
        Account user = userMapper.selectAccountByName("arganzheng");
        Assert.notNull(user);
    }

}
