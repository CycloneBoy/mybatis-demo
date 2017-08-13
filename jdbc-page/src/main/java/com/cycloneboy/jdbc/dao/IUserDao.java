package com.cycloneboy.jdbc.dao;

import com.cycloneboy.jdbc.entity.User;
import com.cycloneboy.jdbc.utils.PageBean;

/**
 * 2. 数据访问层，接口设计
 * Created by CycloneBoy on 2017/8/13.
 */
public interface IUserDao {

    /**
     * 分页查询数据
     */
    public void getAll(PageBean<User> pb);

    /**
     * 查询总记录数
     */
    public int getTotalCount();
}
