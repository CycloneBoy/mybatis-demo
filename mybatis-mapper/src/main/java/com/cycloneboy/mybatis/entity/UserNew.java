package com.cycloneboy.mybatis.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by CycloneBoy on 2017/7/19.
 */
@Alias("u")
public class UserNew {
    private Long id;
    private String userName;
    private String password;
    private String address;

    public UserNew() {
    }

    public UserNew(Long id, String userName, String password, String address) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserNew{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
