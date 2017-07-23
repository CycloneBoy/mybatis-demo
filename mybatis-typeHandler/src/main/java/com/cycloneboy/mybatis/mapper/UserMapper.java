package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.User;
import com.cycloneboy.mybatis.utils.MyDateTypeHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.util.Date;
import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
@MappedJdbcTypes({JdbcType.VARCHAR})
@MappedTypes({Date.class})
public interface UserMapper {

    @Select("select * from user4 ")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "regTime",column = "regTime",
                    typeHandler = MyDateTypeHandler.class,javaType = Date.class,
                    jdbcType = JdbcType.VARCHAR)
    })
    public List<User> getAll();

    @Insert("insert into user4(username,password,regTime) values ( #{username}," +
            "#{password},#{regTime}")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    public int insertUser(User user);
}
