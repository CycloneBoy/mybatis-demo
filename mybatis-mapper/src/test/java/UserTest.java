import com.cycloneboy.mybatis.entity.UserNew;
import com.cycloneboy.mybatis.entity.UserParams;
import com.cycloneboy.mybatis.mapper.UserNewMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CycloneBoy on 2017/7/19.
 */
public class UserTest {

    /**
     * 测试：select中字段的映射问题
     */
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserNewMapper userMapper = sqlSession.getMapper(UserNewMapper.class);
            UserNew user = userMapper.getUser(1L);
            System.out.println("count: " + userMapper.getCount());
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

    /**
     * 测试:select多条件查询
     */
    @Test
    public void test2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserNewMapper userMapper = sqlSession.getMapper(UserNewMapper.class);
            Map<String,String> map = new HashMap<>();
            map.put("address","长沙");
            map.put("username","李");
            List<UserNew> list = userMapper.getUserByAddressAndName2(map);
            for(UserNew userNew : list){
                System.out.println(userNew);
            }

            list = userMapper.getUserByAddressAndName("张","西安");
            for(UserNew userNew : list){
                System.out.println(userNew);
            }

            UserParams userParams = new UserParams("王","武汉");
            list = userMapper.getUserByAddressAndName3(userParams);
            for(UserNew userNew : list){
                System.out.println(userNew);
            }

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

    /**
     * 测试:主键回填
     */
    @Test
    public void test3(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserNewMapper userNewMapper = sqlSession.getMapper(UserNewMapper.class);
            UserNew userNew = new UserNew(null,"大黄蜂","123456","宇宙");
            int i = userNewMapper.insertUser(userNew); //i表示受影响的行数，在这里就是插入的行数
            System.out.println("i: " + i + " ;id: " + userNew.getId());
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
     * 测试:更新、删除、查找
     */
    @Test
    public void test4(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserNewMapper userNewMapper = sqlSession.getMapper(UserNewMapper.class);
            ArrayList<UserNew > list = userNewMapper.getAll();
            for(UserNew userNew : list){
                System.out.println(userNew);
            }
            int i = userNewMapper.deleteUser(4L);
            System.out.println(userNewMapper.getCount());


            UserNew userNew = userNewMapper.getUser(5L);
            userNew.setAddress("地球");
            userNew.setPassword("11111");
            userNewMapper.updateUser(userNew);


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
