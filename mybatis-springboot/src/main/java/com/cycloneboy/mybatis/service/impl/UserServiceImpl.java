package com.cycloneboy.mybatis.service.impl;

import com.cycloneboy.mybatis.dao.UserDao;
import com.cycloneboy.mybatis.entity.User;
import com.cycloneboy.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(Integer id) {
        User user = userDao.selectById(id);
        System.out.println(user);
        return  user;
    }
}
