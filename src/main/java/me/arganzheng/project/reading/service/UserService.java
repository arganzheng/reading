package me.arganzheng.project.reading.service;

import me.arganzheng.project.reading.exception.UserAlreadyExistException;
import me.arganzheng.project.reading.mapper.UserMapper;
import me.arganzheng.project.reading.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userDao;

    public Integer addUser(User user) {
        if (userExist(user)) {
            throw new UserAlreadyExistException();
        }

        return userDao.insertUser(user);
    }

    public boolean userExist(User user) {
        if (userDao.selectUserByUsername(user.getUsername()) != null
            || userDao.selectUserByEmail(user.getEmail()) != null) {
            return true;
        }
        return false;
    }

    public User getUser(String username) {
        return userDao.selectUserByUsername(username);
    }
}
