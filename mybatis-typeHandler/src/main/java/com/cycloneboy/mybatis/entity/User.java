package com.cycloneboy.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public class User implements Serializable{
    private Integer id;
    private String username;
    private String password;
    private Date regTime;

    public User() {
    }

    public User(Integer id, String username, String password, Date regTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.regTime = regTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regTime=" + regTime +
                '}';
    }
}
