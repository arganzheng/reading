package me.arganzheng.project.reading.dao;

import junit.framework.Assert;
import me.arganzheng.project.reading.ReadingTestBase;

import org.springframework.beans.factory.annotation.Autowired;

public class TestMybatisDao extends ReadingTestBase{
	
	@Autowired
	MybatisDao mybatisDao;
	
	public void test(){
		Assert.assertTrue(1 == mybatisDao.test());
	}
	
}
