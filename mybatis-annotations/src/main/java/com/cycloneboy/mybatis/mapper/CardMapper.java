package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Card;
import org.apache.ibatis.annotations.Select;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface CardMapper {

    @Select("select * from t_card where id=#{id}")
    Card selectCardById(Integer id);

}
