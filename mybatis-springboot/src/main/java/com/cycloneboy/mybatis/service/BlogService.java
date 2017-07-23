package com.cycloneboy.mybatis.service;

import com.cycloneboy.mybatis.entity.Article;
import com.cycloneboy.mybatis.entity.Category;
import com.cycloneboy.mybatis.entity.User;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/23.
 */
public interface BlogService {

    /**
     * user service
     */
    public User selectUserById(Integer id);
    public boolean login(String username,String password);

    public Article getArticleById(Integer id);
    public List<Article> getFirst10Article();
    public Article writeBlog(Article article);
    public void  deleteArticleById(Integer id);
    public void updateBlog(Article article);

    public List<Article> getArticleByCategoryName(String name);
    public List<Category> getCategories();
}
