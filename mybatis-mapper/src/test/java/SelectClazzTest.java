import com.cycloneboy.mybatis.entity.Clazz;
import com.cycloneboy.mybatis.entity.Student;
import com.cycloneboy.mybatis.mapper.StudentMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/20.
 */
public class SelectClazzTest {

    /**
     * 测试: 多表查询结果映射
     */
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Clazz> clazzList = studentMapper.selectClazz();
            for(Clazz clazz : clazzList){
                System.out.println(clazz);
                List<Student> studentList = clazz.getStudents();
                for(Student student : studentList){
                    System.out.println(student);
                }
            }

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
