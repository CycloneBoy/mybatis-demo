package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Card;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface CardMapper {

    public Card selectCardById(Integer id);
}
