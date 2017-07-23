package com.cycloneboy.mybatis.dao;

import com.cycloneboy.mybatis.entity.Article;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public interface ArticleDao {

    @Select("select * from t_article where id=#{id}")
    @Results({
        @Result(id = true,column = "id",property = "id"),
            @Result(column = "title",property = "title"),
            @Result(column = "content",property = "content"),
            @Result(column = "date",property = "date"),
            @Result(column = "summary",property = "summary"),
            @Result(column = "category_id",property = "category",
            one = @One(select = "com.cycloneboy.mybatis.dao.CategoryDao.getCategoryById",
            fetchType = FetchType.EAGER))
    })
    public Article getArticleById(int id);

    @Select("select * from t_article ")
    public List<Article> getAll();

    @Delete("delete  from t_article where id=#{id}")
    public void deleteArticleById(int id);

    @Insert("insert into t_article (title,content,category_id,summary,date) " +
            " values (#{title},#{content},#{categoryId},#{summary},#{date})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int addArticle(Article article);

    @Select("select * from t_article where category_id=#{categoryId}")
    public List<Article> getArticleByCategoryId(int categoryId);

    @Update("update t_article set title=#{title},content=#{content},summary=#{summary},date=#{date} where id=#{id}")
    public void updateArticle(Article article);

    @Select("select a.*,c.id as categoryId from t_article a,t_category c where a.category_id=c.id limit 10")
    public List<Article> getFirst10Article();
}
