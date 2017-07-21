import com.cycloneboy.mybatis.entity.User;
import com.cycloneboy.mybatis.mapper.UserMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public class CatchTest {

    /**
     * 测试:一级缓存（Session级的缓存(默认开启))
     */
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.getUser(1L);
            System.out.println(user1);
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
     * 测试:一级缓存（Session级的缓存(默认开启))
     * 如果session执行了DML操作(insert、update、delete)，并提交到数据库，
     * Mybatis会清空session中的一级缓存
     */
    @Test
    public void test2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.getUser(1L);
            System.out.println(user1);
            userMapper.deleteUser(4L);
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
     * 测试:一级缓存（Session级的缓存(默认开启))
     * 如果session执行了DML操作(insert、update、delete)，并提交到数据库，
     * Mybatis会清空session中的一级缓存
     */
    @Test
    public void test3(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.getUser(1L);
            System.out.println(user1);
            sqlSession.close();

            sqlSession = DBUtils.openSqlSession();
            userMapper = sqlSession.getMapper(UserMapper.class);
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
}
