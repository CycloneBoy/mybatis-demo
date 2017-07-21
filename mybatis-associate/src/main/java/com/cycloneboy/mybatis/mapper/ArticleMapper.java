package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Article;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface ArticleMapper {

    public List<Article> selectArticleByOrderId(Integer id);

}
