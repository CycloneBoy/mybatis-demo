package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface PersonMapper {

    @Select("select * from t_person where id=#{id}")
    @Results({
            @Result(id = true,column = "id" ,property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "age",property = "age"),
            @Result(column = "card_id",property = "card",
                one = @One(select = "com.cycloneboy.mybatis.mapper.CardMapper.selectCardById",
                fetchType = FetchType.EAGER))
    })
    Person selectPersonById(Integer id);

}
