package com.cycloneboy.mybatis.mapper;


import com.cycloneboy.mybatis.entity.User;

/**
 * Created by CycloneBoy on 2017/7/19.
 */
public interface UserMapper {

    public User getUser(Long id);

    public int insertUser(User user);

    public void updateUser(User user);

    public int deleteUser(Long id);
}
