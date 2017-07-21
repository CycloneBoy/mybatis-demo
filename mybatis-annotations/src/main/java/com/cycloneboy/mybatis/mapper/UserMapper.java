package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface UserMapper {
    @Insert("insert into user(username,password,address) values(#{username},#{password},#{address})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveUser(User user);

    @Delete("delete from user where id=#{id}")
    int removeUser(@Param("id") Long id);

    @Update("update user set username=#{username},password=#{password},address=#{address} where id=#{id}")
    void modifyUser(User user);

    @Select("select * from user where id=#{id}")
    @Results( {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "address",property = "address")
    })
    User selectUserById(Long id);

    @Select("select * from user")
    List<User> selectAllUser();
}
