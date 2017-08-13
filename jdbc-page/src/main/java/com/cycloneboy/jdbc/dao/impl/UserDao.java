package com.cycloneboy.jdbc.dao.impl;

import com.cycloneboy.jdbc.dao.IUserDao;
import com.cycloneboy.jdbc.entity.User;
import com.cycloneboy.jdbc.utils.JdbcUtils;
import com.cycloneboy.jdbc.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/8/13.
 */
public class UserDao implements IUserDao{
    @Override
    public void getAll(PageBean<User> pb) {
        // 2. 查询总记录数；设置到pb对象中
        int totalCount = this.getTotalCount();
        pb.setTotalCount(totalCount);

       /*
		 * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
		 *              如果当前页为末页，再点下一页显示有问题！
		 * 解决：
		 * 	   1. 如果当前页 <= 0;       当前页设置当前页为1;
		 * 	   2. 如果当前页 > 最大页数；  当前页设置为最大页数
		 */
       // 判断
        if(pb.getCurrentPage() <= 0){
            pb.setCurrentPage(1);                           //把当前页设置为1
        }else if(pb.getCurrentPage() > pb.getTotalPage()){
            pb.setCurrentPage(pb.getTotalPage());            // 把当前页设置为最大页
        }

        //1. 获取当前页：计算查询的起始页、返回的行数
        int currentPage = pb.getCurrentPage();
        int index = (currentPage -1) * pb.getPageCount();       //查询的起始行
        int count = pb.getPageCount();                          //查询返回的行数

        //3. 分页查询数据；把查询到的数据设置到pb对象中
        String sql = "select * from user limit ?,?";

        try {
            // 得到QueryRunner对象
            QueryRunner qr = JdbcUtils.getQueryRunner();
            // 根据当前页,查询当前页数据（一页的数据)
            List<User> pageData = qr.query(sql,new BeanListHandler<User>(User.class),index,count);
            // 设置到pb对象中
            pb.setPageData(pageData);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from user";
        try {
            // 创建QueryRunner对象
            QueryRunner qr = JdbcUtils.getQueryRunner();
            // 执行查询，返回结果的第一行的第一列
            Long count = qr.query(sql,new ScalarHandler<Long>());
            return count.intValue();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
