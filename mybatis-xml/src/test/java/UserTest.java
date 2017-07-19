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
            User user = userMapper.getUser(2L);
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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            for(int i = 0;i < 3 ; i++){
                userMapper.insertUser(new User(null,"u-" + i,"p-" + i,"a-" + i));
            }
            System.out.println("test2: 插入三条记录"  );
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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int i = userMapper.deleteUser(5L);
            System.out.println("test3: 删除一条记录  " + i);
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
