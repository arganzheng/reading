package me.arganzheng.project.reading.service;

import me.arganzheng.project.reading.exception.ResourceAlreadyExistException;
import me.arganzheng.project.reading.mapper.UserMapper;
import me.arganzheng.project.reading.model.User;
import me.arganzheng.project.reading.util.PasswordUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userDao;

    public Integer addUser(User user) {
        if (userExist(user)) {
            throw new ResourceAlreadyExistException(user.getUsername() + " aleardy exist!");
        }
        user.setPassword(PasswordUtils.generatePasswordHash(user.getPassword()));
        return userDao.insert(user);
    }

    public boolean userExist(User user) {
        if (userDao.selectByUsername(user.getUsername()) != null) {
            return true;
        }
        return false;
    }

    public User getByUsername(String name) {
        return userDao.selectByUsername(name);
    }

    public User verifyPassword(String username, String password) {
        User user = getByUsername(username);
        boolean pass = user != null && PasswordUtils.checkPasswordHash(password, user.getPassword());
        return pass ? user : null;
    }
}
