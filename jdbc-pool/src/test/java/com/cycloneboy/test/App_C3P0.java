package com.cycloneboy.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by CycloneBoy on 2017/8/13.
 */
public class App_C3P0 {

    //1. 硬编码方式,使用C3P0连接池管理连接
    @Test
    public void testCode() throws Exception{
        // 创建连接池核心工具类
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 设置连接参数：url、驱动、用户密码、初始连接数、最大连接数
        dataSource.setJdbcUrl("jdbc:mysql:///mybatis-demo?useSSL=false");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setInitialPoolSize(3);
        dataSource.setMaxPoolSize(6);
        dataSource.setMaxIdleTime(1000);

        // 从连接池对象中，获取连接对象
        Connection con = dataSource.getConnection();
        // 执行更新
        con.prepareStatement("delete from user where id = 3").executeUpdate();

        // 关闭
        con.close();

    }

    //2. xml 配置方式,使用C3P0连接池管理连接
    @Test
    public void testXML() throws Exception{
        // 创建c3p0连接池核心工具类
        // 自动加载src下的c3p0配置文件【c3p0-config.xml】
        ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle_config"); //使用默认的配置方式
        PreparedStatement pstmt = null;

        // 获取连接
        Connection con = dataSource.getConnection();
        for(int i=1;i < 20 ;i++){
            String sql = "insert into user(username,password,address) values(?,?,?)";
            //执行更新
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,"Rose" + i);
            pstmt.setString(2,"1"+i);
            pstmt.setString(3,"武汉");
            pstmt.executeUpdate();
        }
        pstmt.close();
        // 关闭
        con.close();
    }
}
