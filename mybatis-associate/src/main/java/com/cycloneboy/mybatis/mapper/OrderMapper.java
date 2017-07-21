package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Order;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface OrderMapper {

    public Order selectOrderById(Integer id);

    public List<Order> selectOrderByUserId(Integer id);
}
