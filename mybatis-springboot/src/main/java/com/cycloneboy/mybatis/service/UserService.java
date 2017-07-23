package com.cycloneboy.mybatis.service;

import com.cycloneboy.mybatis.entity.User;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public interface UserService {

    public User selectUserById(Integer id);

}
