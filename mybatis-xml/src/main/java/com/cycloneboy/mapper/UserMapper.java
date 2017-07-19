package com.cycloneboy.mapper;

import com.cycloneboy.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by CycloneBoy on 2017/7/19.
 */
public interface UserMapper {

    public User getUser(Long id);

    public int insertUser(User user);

    public int deleteUser(Long id);
}
