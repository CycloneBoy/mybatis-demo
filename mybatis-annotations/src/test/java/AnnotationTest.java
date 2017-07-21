import com.cycloneboy.mybatis.entity.User;
import com.cycloneboy.mybatis.mapper.UserMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public class AnnotationTest {

    @Test
    public void insertTest(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = new User(null,"test","123456","北京");
            userMapper.saveUser(user);
            System.out.println(user.getId());
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
    public void selectTest(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user1 = userMapper.selectUserById(3L);
            System.out.println(user1.getId());

            List<User> userList = userMapper.selectAllUser();
            userList.forEach(user -> System.out.println(user));

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
    public void updateTest(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user =userMapper.selectUserById(6L);
            user.setUsername("update");
            user.setPassword("11111");
            user.setAddress("厦门");
            userMapper.modifyUser(user);;
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
    public void deleteTest(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = userMapper.selectUserById(7L);
            System.out.println(user);
            userMapper.removeUser(7L);
            user = userMapper.selectUserById(7L);
            System.out.println(user);
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
