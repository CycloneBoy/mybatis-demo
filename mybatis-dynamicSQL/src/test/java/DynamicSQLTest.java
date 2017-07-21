
import com.cycloneboy.mybatis.entity.Employee;
import com.cycloneboy.mybatis.mapper.EmployeeMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/20.
 */
public class DynamicSQLTest {

    /**
     * 测试:if
     */
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            testSelectEmployeeByIdLike(sqlSession);
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
     * 测试: choose ,when
     */
    @Test
    public void test2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            testSelectEmployeeChoose(sqlSession);
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
     * 测试: where
     */
    @Test
    public void test3(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            testSelectEmployeeLike(sqlSession);
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
     * 测试: set
     */
    @Test
    public void test4(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectEmployeeWithId(4);
            System.out.println(employee);
            employee.setLoginname("mary");
            employee.setPassword("123");
            employee.setName("玛丽");
            employeeMapper.updateEmployeeIfNecessary(employee);

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
     * 测试: foreach
     */
    @Test
    public void test5(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            List<Employee> employeeList = employeeMapper.selectEmployeeIn(ids);
            employeeList.forEach(employee -> System.out.println(employee));

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
     * 测试: bind
     */
    @Test
    public void test6(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = new Employee();
            employee.setName("o");
            List<Employee> employeeList =employeeMapper.selectEmployeeLikeName(employee);
            employeeList.forEach(employee1 -> System.out.println(employee1));
            //System.out.println(employeeList);
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


    public void testSelectEmployeeByIdLike(SqlSession sqlSession){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String,Object> params = new HashMap<>();
       // params.put("id",1);
        params.put("loginname","jack");
        params.put("password","123456");
        List<Employee> employeeList = employeeMapper.selectEmployeeByIdLike(params);
        employeeList.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeChoose(SqlSession sqlSession){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String,Object> params = new HashMap<>();
        //params.put("id",1);
        // params.put("loginname","jack");
        //params.put("password","123456");
        List<Employee> employeeList = employeeMapper.selectEmployeeChoose(params);
        employeeList.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeLike(SqlSession sqlSession){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String,Object> params = new HashMap<>();
        //params.put("id",1);
        // params.put("loginname","jack");
        //params.put("password","123456");
        params.put("state","ACTIVE");
        List<Employee> employeeList = employeeMapper.selectEmployeeLike(params);
        employeeList.forEach(employee -> System.out.println(employee));
    }
}
