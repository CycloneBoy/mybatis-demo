import com.cycloneboy.mybatis.entity.User;
import com.cycloneboy.mybatis.mapper.UserMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public class TypeHandlerTest {

    @Test
    public void test(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(null,"李四","123456",new Date());
            userMapper.insertUser(user);
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
}
