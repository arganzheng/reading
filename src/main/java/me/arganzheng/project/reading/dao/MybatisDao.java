package me.arganzheng.project.reading.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;  
	
    public Integer test(){
    	return sqlSessionTemplate.selectOne("test.test");
    }  
}
