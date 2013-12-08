package me.arganzheng.project.reading.mapper;

import me.arganzheng.project.reading.model.User;

public interface UserMapper {

    public User selectUserById(Integer id);

    public User selectUserByUsername(String username);

    public User selectUserByEmail(String email);

    public Integer insertUser(User user);

    public boolean updateUser(User user);

    public int deleteUser(Integer id);
}
