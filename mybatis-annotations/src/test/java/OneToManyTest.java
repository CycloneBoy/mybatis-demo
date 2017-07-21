import com.cycloneboy.mybatis.entity.Clazz;
import com.cycloneboy.mybatis.entity.Person;
import com.cycloneboy.mybatis.mapper.ClazzMapper;
import com.cycloneboy.mybatis.mapper.PersonMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public class OneToManyTest {

    @Test
    public void test(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
            Clazz clazz = clazzMapper.selectById(1);
            System.out.println(clazz.getId() + " " + clazz.getCode());
            clazz.getStudents().forEach(student -> System.out.println(student));

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
