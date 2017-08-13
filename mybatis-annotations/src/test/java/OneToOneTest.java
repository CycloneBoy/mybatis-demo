import com.cycloneboy.mybatis.entity.Person;
import com.cycloneboy.mybatis.mapper.PersonMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public class OneToOneTest {
    @Test
    public void oneTest(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person = personMapper.selectPersonById(1);

            System.out.println(person);

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
