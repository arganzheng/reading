package me.arganzheng.project.reading.dao;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.model.Account;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * TODO 类实现描述
 * 
 * @author arganzheng
 * @date 2013-12-18
 */
public class AccountDaoTest extends BaseSpringTestCase {

    @Autowired
    private AccountDao accountDao;

    @Test
    public void testSelectAccountByName() {
        Account user = accountDao.selectAccountByName("arganzheng");
        Assert.notNull(user);

    }
}
