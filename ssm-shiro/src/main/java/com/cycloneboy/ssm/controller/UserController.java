package com.cycloneboy.ssm.controller;

import com.cycloneboy.ssm.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by CycloneBoy on 2017/8/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(User user, HttpServletRequest request, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try{
            subject.login(token);
            session.setAttribute("user",user);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            session.setAttribute("user",user);
            request.setAttribute("error","用户名或者密码错误");
            return "login";
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return  "index";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(HttpServletRequest request){
        return "success";
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String student(HttpServletRequest request){
        return "success";
    }

    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public String teacher(HttpServletRequest request){
        return "success";
    }
}
