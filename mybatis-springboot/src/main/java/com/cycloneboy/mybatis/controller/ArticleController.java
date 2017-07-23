package com.cycloneboy.mybatis.controller;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlLoadDataInFileStatement;
import com.cycloneboy.mybatis.entity.Article;
import com.cycloneboy.mybatis.entity.Category;
import com.cycloneboy.mybatis.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tautua.markdownpapers.Markdown;
import org.tautua.markdownpapers.parser.ParseException;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/23.
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    private BlogServiceImpl blogService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        List<Article> articleList = blogService.getFirst10Article();
        articleList.forEach(article -> System.out.println(article));
        modelMap.addAttribute("articles",articleList);
        return "article/index";
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id") Integer id,ModelMap modelMap){
        Article article = blogService.getArticleById(id);
        Markdown markdown = new Markdown();
        try{
            StringWriter out = new StringWriter();
            markdown.transform(new StringReader(article.getContent()),out);
            out.flush();
            article.setContent(out.toString());
            System.out.println("------------------------");
            System.out.println(article.getContent());
        }catch (ParseException e){
            e.printStackTrace();
        }
        modelMap.addAttribute("article",article);
        return "article/detail";

    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id){
        blogService.deleteArticleById(id);
        return "redirect:/article";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id,ModelMap modelMap){
        Article article = blogService.getArticleById(id);
        modelMap.addAttribute("article",article);
        return "article/write";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        List<Category> categoryList = blogService.getCategories();
        modelMap.addAttribute("categoryList",categoryList);

        return "article/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addP(@ModelAttribute("article") Article article){

        blogService.writeBlog(article);
        System.out.println("文章标题: " + article.getId());

        return "redirect:/article";
    }

}
