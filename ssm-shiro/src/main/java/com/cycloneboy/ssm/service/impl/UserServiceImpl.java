package com.cycloneboy.ssm.service.impl;

import com.cycloneboy.ssm.dao.UserDao;
import com.cycloneboy.ssm.entity.User;
import com.cycloneboy.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by CycloneBoy on 2017/8/1.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public Set<String> getRoles(String username) {
        return userDao.getRoles(username);
    }

    @Override
    public Set<String> getPermissions(String username) {
        return userDao.getPermissions(username);
    }
}
