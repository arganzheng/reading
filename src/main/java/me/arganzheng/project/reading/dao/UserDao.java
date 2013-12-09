package me.arganzheng.project.reading.dao;

import me.arganzheng.project.reading.model.User;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public User selectUserByUsername(String username) {
        return (User) sqlSession.selectOne("me.arganzheng.project.reading.mapper.UserMapper.selectUserByUsername",
                                           username);
    }
}
