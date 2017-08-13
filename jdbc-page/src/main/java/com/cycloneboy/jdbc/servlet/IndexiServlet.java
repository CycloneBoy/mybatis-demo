package com.cycloneboy.jdbc.servlet;

import com.cycloneboy.jdbc.entity.User;
import com.cycloneboy.jdbc.service.IUserService;
import com.cycloneboy.jdbc.service.impl.UserService;
import com.cycloneboy.jdbc.utils.PageBean;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by CycloneBoy on 2017/8/13.
 */
public class IndexiServlet extends HttpServlet {

    // 创建Service实例
    private IUserService userService = new UserService();
    // 跳转资源
    private  String uri;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1. 获取" 当前页" 参数; （第一次访问当前页为null)
            String currPage = request.getParameter("currentPage");
            // 判断
            if(currPage == null || "".equals(currPage.trim())){
                currPage = "1";  // 第一次访问，设置当前页为1
            }
            // 转换
            int currentPage = Integer.parseInt(currPage);

            // 2. 创建PageBean对象，设置当前页参数; 传入service方法参数
            PageBean<User> pageBean = new PageBean<User>();
            pageBean.setCurrentPage(currentPage);

            // 3. 调用service
            userService.getAll(pageBean);       // 【pageBean已经被Dao 填充了数据】

            // 4. 保存pageBean对象，到request域中
            request.setAttribute("pageBean",pageBean);

            // 5. 跳转
            uri = "/WEB-INF/list.jsp";
        }catch (Exception e){
            e.printStackTrace();
            uri = "/error/error.jsp";
        }
        request.getRequestDispatcher(uri).forward(request,response);
    }
}
