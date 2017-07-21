package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Person;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface PersonMapper {

    public Person selectPersonById(Integer id);

}
