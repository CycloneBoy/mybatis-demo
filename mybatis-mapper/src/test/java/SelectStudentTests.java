import com.cycloneboy.mybatis.entity.Student;
import com.cycloneboy.mybatis.mapper.StudentMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/20.
 */
public class SelectStudentTests {

    /**
     * 测试：select中字段的映射问题
     */
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.selectStudent();

            for(Student student : studentList){
                System.out.println(student);
            }
            System.out.println("学生总数: " + studentMapper.getCount());
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

}
