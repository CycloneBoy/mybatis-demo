import com.cycloneboy.mybatis.entity.Employee;
import com.cycloneboy.mybatis.mapper.EmployeeMapper;
import com.cycloneboy.mybatis.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public class DynamicSQLTest {

    @Test
    public void selectTest(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
            employee.setId(4);
            employee.setSex("女");
            List<Employee> employeeList = employeeMapper.selectWithEmployee(employee);
            employeeList.forEach(employee1 -> System.out.println(employee1));

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

    @Test
    public void insertTest(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
            employee.setLoginname("ailis");
            employee.setPassword("11111");
            employee.setName("爱丽丝");
            employee.setSex("女");
            employee.setAge(20);
            employee.setPhone("13011112222");
            employee.setSal(8000.2);
            //employee.setState("ACTIVE");

            employeeMapper.insertEmployee(employee);
            System.out.println(employee.getId());

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

    @Test
    public void updateTest(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
            employee.setId(6);
            employee.setLoginname("Aliyun");
            employee.setPassword("222222");
            employee.setState("ACTIVE");

            employeeMapper.updateEmployee(employee);
            System.out.println(employee.getId());

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

    @Test
    public void deleteTest(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
            employee.setId(6);

            employeeMapper.deleteEmployee(employee);
            System.out.println(employee.getId());

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
