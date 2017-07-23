package com.cycloneboy.mybatis.dao;

import com.cycloneboy.mybatis.common.BaseDao;
import com.cycloneboy.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public interface UserDao extends BaseDao<User>{

    @Select("select * from t_user where id=#{id}")
    public User selectById(Integer id);

    @Select("select * from t_user where loginname=#{loginname} and password=#{password} ")
    public User getUser(@Param("loginname") String loginname ,@Param("password") String password);


}
