package com.cycloneboy.mybatis.dao;

import com.cycloneboy.mybatis.common.BaseDao;
import com.cycloneboy.mybatis.entity.Category;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public interface CategoryDao extends BaseDao<Category>{

    @Select("select * from t_category where id=#{id} ")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "display_name",property = "displayName")/*,
            @Result(column = "id" ,property = "articles",
            many = @Many(
                    select = "com.cycloneboy.mybatis.dao.ArticleDao.getArticleByCategoryId",
                    fetchType = FetchType.LAZY))*/
    })
    public Category getCategoryById(int id);

    @Select("select * from t_category where name=#{name}")
    public  Category getCategoryByName(String name);

    @Select("select * from t_category ")
    public List<Category> getCategories();
}
