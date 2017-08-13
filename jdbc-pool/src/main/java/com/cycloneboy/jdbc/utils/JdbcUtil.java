package com.cycloneboy.jdbc.utils;

import java.sql.*;

/**
 * 说明:
 *      1.返回连接 2.关闭
 * Created by CycloneBoy on 2017/8/13.
 */
public class JdbcUtil {

    //连接参数
    //private static String url = "jdbc:mysql://localhost:3306/mybatis-demo";
    private static String url = "jdbc:mysql:///mybatis-demo";
    private static String user ="root";
    private static String password ="123456";

    /**
     * 返回连接数
     */
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    /**
     * 关闭
     */
    public static void closeAll(Connection con, Statement stmt, ResultSet rs){
        try {
            if(rs != null){
                rs.close(); // 快速异常捕获 Ctrl + Alt + T
                rs = null;  //建议垃圾回收期间回收资源
            }
            if(stmt != null){
                stmt.close();
                stmt = null;
            }
            if(con != null){
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
