package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.User;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface UserMapper {

    public User selectUserById(int id);

}
