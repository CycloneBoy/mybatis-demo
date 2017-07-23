package com.cycloneboy.mybatis;

import com.cycloneboy.mybatis.dao.CategoryDao;
import com.cycloneboy.mybatis.entity.Category;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public class CategoryDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
            Category category = categoryDao.getCategoryById(1);
            System.out.println(category);

            category.getArticles().forEach(article -> System.out.println(article));

            Category category1 = categoryDao.getCategoryByName("webPage");
            System.out.println(category1);

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
