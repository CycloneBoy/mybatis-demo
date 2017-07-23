package com.cycloneboy.mybatis.service.impl;

import com.cycloneboy.mybatis.dao.ArticleDao;
import com.cycloneboy.mybatis.dao.CategoryDao;
import com.cycloneboy.mybatis.dao.UserDao;
import com.cycloneboy.mybatis.entity.Article;
import com.cycloneboy.mybatis.entity.Category;
import com.cycloneboy.mybatis.entity.User;
import com.cycloneboy.mybatis.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/23.
 */
@Service
public class BlogServiceImpl implements BlogService{

    private Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private UserDao userDao;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;


    @Override
    public User selectUserById(Integer id) {
        User user = userDao.selectById(id);
        System.out.println(user);
        logger.info("查找用户");
        return  user;
    }

    @Override
    public boolean login(String username, String password) {
        User user = userDao.getUser(username,password);
        if(user == null){
            return  false;
        }else{
            logger.info("成功登录: " + username + " " + password);
            return  true;
        }
    }

    @Override
    public Article getArticleById(Integer id) {
        Article article = articleDao.getArticleById(id);
        logger.info("返回article：" + article.getId());
        return article;
    }

    @Override
    public List<Article> getFirst10Article() {
        logger.info("查找前10篇博客");
        return articleDao.getFirst10Article();
    }

    @Override
    public Article writeBlog(Article article) {
        article.setDate(sdf.format(new Date()));
        if(article.getSummary() == null || "".equals(article.getSummary())){
            if(article.getContent().length() > 20){
                article.setSummary(article.getContent().substring(0,20));
            }else {
                article.setSummary(article.getContent().substring(0,article.getContent().length()));
            }
        }
        articleDao.addArticle(article);
        logger.info("添加一篇博客：" +article.getId());
        return article;
    }
    @Override
    public void deleteArticleById(Integer id) {
        logger.info("删除一篇博客: " + id);
        articleDao.deleteArticleById(id);
    }

    @Override
    public void updateBlog(Article article) {
        article.setDate(sdf.format(new Date()));
        if(article.getSummary() == null || "".equals(article.getSummary())){
            if(article.getContent().length() > 20){
                article.setSummary(article.getContent().substring(0,20));
            }else {
                article.setSummary(article.getContent().substring(0,article.getContent().length()));
            }
        }
        articleDao.updateArticle(article);
        logger.info("修改一篇博客: " + article.getId());
    }

    @Override
    public List<Article> getArticleByCategoryName(String name) {
        Category category = categoryDao.getCategoryByName(name);
        List<Article> articleList = articleDao.getArticleByCategoryId(category.getId());
        logger.info("查找指定专栏名字的博客: " +name );
        return articleList;
    }

    @Override
    public List<Category> getCategories() {
        logger.info("查找所有专栏");
        return categoryDao.getCategories();
    }
}
