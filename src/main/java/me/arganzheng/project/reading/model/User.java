package me.arganzheng.project.reading.model;

import java.util.Date;

import me.arganzheng.project.reading.constants.Role;
import me.arganzheng.project.reading.constants.Status;

/**
 * 用户领域对象。
 * 
 * @author arganzheng
 * @date 2013-12-7
 */
public class User {

    private Integer id;

    private Date    createdTime;

    private Date    modifiedTime;

    private String  username;

    private String  email;

    private Role    role   = Role.User;

    private Status  status = Status.Activite;

    private String  password;

    public User(){
    }

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", username="
               + username + ", email=" + email + ", role=" + role + ", status=" + status + ", password=" + password
               + "]";
    }

}
