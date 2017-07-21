import com.cycloneboy.mybatis.entity.Article;
import com.cycloneboy.mybatis.entity.Order;
import com.cycloneboy.mybatis.entity.User;
import com.cycloneboy.mybatis.mapper.OrderMapper;
import com.cycloneboy.mybatis.mapper.UserMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public class ManyToManyTest {
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            testSelectUserById(sqlSession);
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
            testSelectOrderById(sqlSession);
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

    public void testSelectUserById(SqlSession sqlSession){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(1);
        System.out.println(user.getId() + " " + user.getUsername());
        List<Order> orderList = user.getOrders();
        for(Order order : orderList){
            System.out.println(order);
        }
    }

    public void testSelectOrderById(SqlSession sqlSession){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderById(2);
        System.out.println(order.getId() + " " + order.getCode() + " " + order.getTotal());

        User user = order.getUser();
        System.out.println(user);
        List<Article> articleList = order.getArticles();
        for(Article article : articleList){
            System.out.println(article);
        }

    }
}
