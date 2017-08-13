package com.cycloneboy.jdbc.service;

import com.cycloneboy.jdbc.entity.User;
import com.cycloneboy.jdbc.utils.PageBean;

/**
 * 3. 业务逻辑层接口设计
 * Created by CycloneBoy on 2017/8/13.
 */
public interface IUserService {

    /**
     * 分页查询数据
     */
    public void getAll(PageBean<User> pb);
}
