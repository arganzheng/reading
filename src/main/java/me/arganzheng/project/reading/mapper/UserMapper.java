package me.arganzheng.project.reading.mapper;

import me.arganzheng.project.reading.model.User;

/**
 * <pre>
 * 为了代替手工使用 SqlSessionDaoSupport 或 SqlSessionTemplate 编写数据访问对象 (DAO)的代码,
 * MyBatis-Spring 提供了一个动态代理的实现:MapperFactoryBean。
 * 如果接口上有写SQL annotation，否则走XML文件（需要配置XML路径），另外id必须与接口方法名称相同。
 * @see http://mybatis.github.io/spring/zh/mappers.html
 * 
 * </pre>
 * 
 * @author arganzheng
 * @date 2013-12-09
 */
public interface UserMapper {

    public User selectUserById(Integer id);

    public User selectUserByUsername(String username);

    public User selectUserByEmail(String email);

    public Integer insertUser(User user);

    public boolean updateUser(User user);

    public int deleteUser(Integer id);
}
