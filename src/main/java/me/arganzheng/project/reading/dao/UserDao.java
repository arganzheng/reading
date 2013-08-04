package me.arganzheng.project.reading.dao;

import me.arganzheng.project.reading.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao {

    public User selectUserById(Integer id) {
        return (User) getSqlMapClientTemplate().queryForObject("t_reading_user.selectById", id);
    }

    public User selectUserByUsername(String username) {
        return (User) getSqlMapClientTemplate().queryForObject("t_reading_user.selectByUsername", username);
    }

    public User selectUserByEmail(String email) {
        return (User) getSqlMapClientTemplate().queryForObject("t_reading_user.selectByEmail", email);
    }

    public Integer insertUser(User user) {
        return (Integer) getSqlMapClientTemplate().insert("t_reading_user.insert", user);
    }

    public boolean updateUser(User user) {
        return getSqlMapClientTemplate().update("t_reading_user.update", user) > 0;
    }

    public int deleteUser(Integer id) {
        return getSqlMapClientTemplate().delete("t_reading_user.delete", id);
    }

}
