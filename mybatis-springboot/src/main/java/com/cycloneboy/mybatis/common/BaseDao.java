package com.cycloneboy.mybatis.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public interface BaseDao<T> extends Mapper<T>,MySqlMapper<T> {
}
