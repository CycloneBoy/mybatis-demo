package com.cycloneboy.mybatis.controller;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlLoadDataInFileStatement;
import com.cycloneboy.mybatis.entity.Article;
import com.cycloneboy.mybatis.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/23.
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    private BlogServiceImpl blogService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        List<Article> articleList = blogService.getFirst10Article();
        articleList.forEach(article -> System.out.println(article));
        modelMap.addAttribute("articles",articleList);
        return "article/index";
    }


}
