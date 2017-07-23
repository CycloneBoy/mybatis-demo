package com.cycloneboy.mybatis.controller;


import com.cycloneboy.mybatis.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/h" ,method = RequestMethod.GET)
    public Object test(){

        return  userService.selectUserById(1);
    }

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public ModelAndView index(){
        return  new ModelAndView("index");
    }
}
