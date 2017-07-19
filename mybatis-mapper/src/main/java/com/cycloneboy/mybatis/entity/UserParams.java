package com.cycloneboy.mybatis.entity;

/**
 * Created by CycloneBoy on 2017/7/19.
 */
public class UserParams {
    private String username;
    private String address;

    public UserParams() {
    }

    public UserParams(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
