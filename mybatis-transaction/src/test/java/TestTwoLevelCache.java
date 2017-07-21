import com.cycloneboy.mybatis.entity.User;
import com.cycloneboy.mybatis.mapper.UserMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public class TestTwoLevelCache {

    /**
     * 测试:二级缓存
     */
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.getUser(1L);
            System.out.println(user1);
            userMapper.deleteUser(5L);
            sqlSession.commit();

            User user2 = userMapper.getUser(1L);
            System.out.println(user2);
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

    /**
     * 测试:二级缓存
     */
    @Test
    public void test2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.getUser(1L);

            //System.out.println(user1);
            sqlSession.close();

            sqlSession = DBUtils.openSqlSession();
            userMapper = sqlSession.getMapper(UserMapper.class);

            User user2 = userMapper.getUser(1L); //缓存命中
            System.out.println(user2);
            System.out.println(user1);
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
