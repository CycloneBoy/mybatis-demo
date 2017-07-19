package com.cycloneboy.mapper;

import com.cycloneboy.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by CycloneBoy on 2017/7/19.
 */
public interface UserMapper {

    @Select(value = "select * from user where id=#{id}")
    public User getUser(Long id);
}
