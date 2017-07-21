package com.cycloneboy.mybatis.mapper.many;


import com.cycloneboy.mybatis.entity.many.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface UserMapper {

    @Select("select * from t_user where id=#{id}")
    public User selectUserById(int id);

}
