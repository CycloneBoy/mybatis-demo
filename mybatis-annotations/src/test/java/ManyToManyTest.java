import com.cycloneboy.mybatis.entity.many.Order;
import com.cycloneboy.mybatis.mapper.many.OrderMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public class ManyToManyTest {
    @Test
    public void test(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            Order order = orderMapper.selectOrderById(1);
            System.out.println(order.getId() + " " + order.getCode() + " " + order.getTotal());
            System.out.println(order.getUser());

            order.getArticles().forEach(article -> System.out.println(article));

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
