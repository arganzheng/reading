package me.arganzheng.project.reading.dao;

import me.arganzheng.project.reading.model.User;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public User selectUserByUsername(String username) {
        return (User) sqlSession.selectOne("me.arganzheng.project.reading.mapper.UserMapper.selectUserByUsername",
                                           username);
    }
}
