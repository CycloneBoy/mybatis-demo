package com.cycloneboy.jdbc.b_pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 自定义连接池, 管理连接
 * 代码实现：
 1.  MyPool.java  连接池类，
 2.  指定全局参数：  初始化数目、最大连接数、当前连接、   连接池集合
 3.  构造函数：循环创建3个连接
 4.  写一个创建连接的方法
 5.  获取连接
 ------>  判断： 池中有连接， 直接拿
 ------>                池中没有连接，
 ------>                 判断，是否达到最大连接数； 达到，抛出异常；没有达到最大连接数，
 创建新的连接
 6. 释放连接
 ------->  连接放回集合中(..)
 * Created by CycloneBoy on 2017/8/13.
 */
public class MyPool {
    private int init_count = 3;   // 初始化连接数目
    private int max_count = 6;    // 最大连接数
    private int current_count = 0; // 记录当前使用连接数
    // 连接池 (存放所有的初始化连接)
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    //1. 构造函数中,初始化连接放入连接池
    public MyPool(){
        // 初始化连接
        for(int i =0; i < init_count; i++){
            // 记录当前连接数
            current_count++;
            // 创建原始的连接对象
            Connection con = createConnection();
            // 把连接加入连接池
            pool.addLast(con);
        }
    }

    //2. 创建一个新的连接
    private Connection createConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 原始的目标对象
            final Connection con = DriverManager.getConnection("jdbc:mysql:///mybatis-demo?useSSL=false","root","123456");

            /****************对con 创建代理对象*******************/

            // 对con 创建代理对象
            Connection proxy = (Connection) Proxy.newProxyInstance(
                    con.getClass().getClassLoader(),    //类加载器
                    //con.getClass().getInterfaces(),   // 当目标对象是一个具体的类的时候
                    new Class[]{Connection.class},      // 目标对象实现的接口
                    new InvocationHandler() {           // 当调用con对象方法的时候,自动触发事务处理器
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args)
                                throws Throwable {
                            // 方法返回值
                            Object result = null;
                            // 当执行的方法的方法名
                            String methodName = method.getName();

                            //判断当执行了close 方法的时候，把连接放入连接池
                            if("close".equals(methodName)){
                                System.out.println("begin：当前执行close方法开始!");
                                // 连接放入连接池
                                pool.addLast(con);
                                System.out.println("end：当前连接已经放入了连接池了!");
                            }else{
                                // 调用目标对象的方法
                                result = method.invoke(con,args);
                            }

                            return result;
                        }
                    }
            );
            return  proxy;

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //3. 获取连接
    public Connection getConnection(){

        //3.1 判断连接池中是否有连接，如果有连接，就直接从连接池中取出
        if(pool.size() > 0){
            return pool.removeFirst();
        }

        //3.2 连接池中没有连接：判断，如果没有达到最大的连接数，创建
        if(current_count < max_count){
            // 记录当前使用的连接数
            current_count++;
            // 创建连接
            return createConnection();
        }

        //3.3 如果当前已经达到最大连接数，抛出异常
        throw  new RuntimeException("当前已经达到最大连接数!");
    }

    //4. 释放连接
    public  void realeaseConnection(Connection con){
        //4.1 判断: 池中的数目如果小于初始化连接，就放入池中
        if(pool.size() < init_count){
            pool.addLast(con);
        }else {
            try {
                //关闭
                current_count--;
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws SQLException{
        MyPool pool = new MyPool();
        System.out.println("当前连接数: " + pool.current_count);

        // 使用连接
        pool.getConnection();
       // pool.getConnection();

        Connection con1  = pool.getConnection();


        // 释放连接，连接放回连接池
        //pool.realeaseConnection(con1);
        //pool.realeaseConnection(con2);
        //pool.realeaseConnection(con3);
        System.out.println("当前连接数: " + pool.current_count);

        /*
		 * 希望：当关闭连接的时候，要把连接放入连接池！
		 * 【当调用Connection接口的close方法时候，希望触发pool.addLast(con);操作】
		 *
		 * 	把连接放入连接池
		 * 解决1：实现Connection接口，重写close方法
		 * 解决2：动态代理
		 */

        con1.close();
        System.out.println("当前连接数: " + pool.current_count);

        // 再获取
        pool.getConnection();

        System.out.println("连接池: " + pool.pool.size());
        System.out.println("当前连接: " + pool.current_count );
    }
}
