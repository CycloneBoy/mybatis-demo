package com.cycloneboy.mybatis;

import com.cycloneboy.mybatis.dao.ArticleDao;
import com.cycloneboy.mybatis.entity.Article;
import com.cycloneboy.mybatis.entity.Category;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/23.
 */
public class ArticleDaoTest {

    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            ArticleDao articleDao = sqlSession.getMapper(ArticleDao.class);

            List<Article> articleList = articleDao.getAll();
            articleList.forEach(article -> System.out.println(article));

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

    @Test
    public void test2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            ArticleDao articleDao = sqlSession.getMapper(ArticleDao.class);

            Article article = articleDao.getArticleById(1);
            System.out.println(article);
            Category category = article.getCategory();
            System.out.println(category);

            articleDao.deleteArticleById(7);

            Article article1 = new Article();
            article1.setTitle("文章1");
            article1.setContent("天下文章");
            article1.setCategoryId(2);
            article1.setSummary("很好");
            article1.setDate("2017-07-23");
            int i = articleDao.addArticle(article1);
            System.out.println(i + " " + article1.getId());

            List<Article> articleList = articleDao.getArticleByCategoryId(1);
            articleList.forEach(article2 -> System.out.println(article2));
            System.out.println("----------------------------------------");
            List<Article> articleList1 = articleDao.getFirst10Article();
            articleList1.forEach(article3 -> System.out.println(article3));

            article1.setSummary("非常好");
            article1.setContent("神作");
            articleDao.updateArticle(article1);

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
