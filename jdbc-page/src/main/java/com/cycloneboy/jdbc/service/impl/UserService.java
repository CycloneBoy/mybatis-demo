package com.cycloneboy.jdbc.service.impl;

import com.cycloneboy.jdbc.dao.IUserDao;
import com.cycloneboy.jdbc.dao.impl.UserDao;
import com.cycloneboy.jdbc.entity.User;
import com.cycloneboy.jdbc.service.IUserService;
import com.cycloneboy.jdbc.utils.PageBean;

/**
 * Created by CycloneBoy on 2017/8/13.
 */
public class UserService implements IUserService{

    // 创建Dao实例
    private IUserDao userDao = new UserDao();

    @Override
    public void getAll(PageBean<User> pb) {
        try{
            userDao.getAll(pb);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
