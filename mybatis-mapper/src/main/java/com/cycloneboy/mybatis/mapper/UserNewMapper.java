package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.UserNew;
import com.cycloneboy.mybatis.entity.UserParams;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/19.
 */
public interface UserNewMapper {

    public UserNew getUser(Long id);

    public List<UserNew> getUserByAddressAndName(
            @Param("username") String username,@Param("address") String address);

    public ArrayList<UserNew> getUserByAddressAndName2(UserParams params);

    // 待完成...


    public int insertUser(UserNew user);

    public void updateUser(UserNew user);

    public int deleteUser(Long id);
}
