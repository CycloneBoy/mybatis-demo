
import com.cycloneboy.mybatis.entity.Person;
import com.cycloneboy.mybatis.mapper.PersonMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by CycloneBoy on 2017/7/20.
 */
public class OneToOneTest {

    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person1 = personMapper.selectPersonById(1);
            System.out.println(person1);

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
