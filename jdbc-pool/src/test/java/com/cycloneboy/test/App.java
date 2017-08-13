package com.cycloneboy.test;

import com.cycloneboy.jdbc.a_hello.User;
import com.cycloneboy.jdbc.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * Created by CycloneBoy on 2017/8/13.
 */
public class App {

    // 1. 使用DbUtils组件更新
    @Test
    public void testUpdate() throws Exception{
        String sql = "delete from user where id = 9";
        //1.1 连接
        Connection con = JdbcUtil.getConnection();
        //1.2 创建核心工具类
        QueryRunner qr = new QueryRunner();
        //1.3 更新
        qr.update(con,sql);

        con.close();
    }

    //2. 使用DbUtils组件查询
    @Test
    public void testQuery() throws Exception{
        String sql = "select * from user";
        //1.1 连接
        Connection con = JdbcUtil.getConnection();
        //1.2 创建核心工具类
        QueryRunner qr  = new QueryRunner();
        //1.3 查询
        List<User> list = qr.query(con,sql,new BeanListHandler<User>(User.class));

        System.out.println(list);

        con.close();
    }
}




