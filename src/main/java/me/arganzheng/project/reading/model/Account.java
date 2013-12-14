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
public class Account {

    private Integer id;

    private Date    createdTime;

    private Date    modifiedTime;

    private String  name;

    private String  email;

    private Role    role   = Role.User;

    private Status  status = Status.Active;

    private String  password;

    public Account(){
    }

    public Account(String username, String email){
        this.name = username;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Account [id=" + id + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", name="
               + name + ", email=" + email + ", role=" + role + ", status=" + status + ", password=" + password + "]";
    }

}