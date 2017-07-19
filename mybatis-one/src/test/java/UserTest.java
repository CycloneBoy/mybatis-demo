import com.cycloneboy.entity.User;
import com.cycloneboy.mapper.UserMapper;
import com.cycloneboy.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by CycloneBoy on 2017/7/19.
 */
public class UserTest {

    @org.junit.Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(3L);
            System.out.println("test1: " + user.toString());
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @org.junit.Test
    public void test2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            User user = (User)sqlSession.selectOne("com.cycloneboy.mapper.UserMapper.getUser",1L);
            System.out.println("test2: " + user.toString());
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }


    @org.junit.Test
    public void test3(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            User user = (User)sqlSession.selectOne("getUser",1L);
            System.out.println("test3: " + user.toString());
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

}
