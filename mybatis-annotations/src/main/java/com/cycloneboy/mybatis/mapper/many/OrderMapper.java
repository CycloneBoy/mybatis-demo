package com.cycloneboy.mybatis.mapper.many;

import com.cycloneboy.mybatis.entity.many.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface OrderMapper {

    @Select("select * from t_order where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "code",property = "code"),
            @Result(column = "total",property = "total"),
            @Result(column = "user_id",property = "user",
                one = @One(select = "com.cycloneboy.mybatis.mapper.many.UserMapper.selectUserById",
                    fetchType = FetchType.EAGER)),
            @Result(column = "id",property = "articles",
                  many = @Many(select = "com.cycloneboy.mybatis.mapper.many.ArticleMapper.selectArticleByOrderId",
                  fetchType = FetchType.LAZY))
    })
    public Order selectOrderById(Integer id);

}
