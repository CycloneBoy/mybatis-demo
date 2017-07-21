package com.cycloneboy.mybatis.mapper.many;



import com.cycloneboy.mybatis.entity.many.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface ArticleMapper {

    @Select("select * from t_article where id in ( " +
            "select article_id from t_item where order_id=#{id} )")
    public List<Article> selectArticleByOrderId(Integer id);

}
