import com.cycloneboy.mybatis.entity.Clazz;
import com.cycloneboy.mybatis.entity.Student;
import com.cycloneboy.mybatis.mapper.ClazzMapper;
import com.cycloneboy.mybatis.mapper.StudentMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public class OneToManyTest {
    /**
     * 测试一对多
     */
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            System.out.println("懒加载(1):");
            testSelectClazzById(sqlSession);
            System.out.println("懒加载(2):");
            testSelectClazzById1(sqlSession);
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
     * 测试一对多
     */
    @Test
    public void test2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            testSelectStudentById(sqlSession);
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
     * 测试一对多
     */
    @Test
    public void test3(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
           testSelectStudentByClazzId(sqlSession);
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
     * 懒加载测试
     * @param sqlSession
     */
    public void testSelectClazzById(SqlSession sqlSession){
        ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = clazzMapper.selectClazzById(1);
        System.out.println(clazz);

    }

    /**
     * 懒加载测试
     * @param sqlSession
     */
    public void testSelectClazzById1(SqlSession sqlSession){
        ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = clazzMapper.selectClazzById(1);
        System.out.println(clazz);
        List<Student> studentList = clazz.getStudents();
        for(Student student : studentList){
            System.out.println(student);
        }
    }

    public void testSelectStudentById(SqlSession sqlSession){
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectStudentById(1);
        System.out.println(student);
        System.out.println(student.getClazz());
    }

    public void testSelectStudentByClazzId(SqlSession sqlSession){
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.selectStudentByClazzId(1);
        for(Student student :studentList){
            System.out.println(student);
        }
    }
}
