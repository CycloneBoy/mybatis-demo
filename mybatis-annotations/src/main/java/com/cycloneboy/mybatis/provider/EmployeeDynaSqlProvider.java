package com.cycloneboy.mybatis.provider;

import java.util.Map;

import com.cycloneboy.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public class EmployeeDynaSqlProvider {

    public String selectWithParam(Map<String,Object> param){
        return new SQL(){
            {
              SELECT("*");
              FROM("t_employee");
              if(param.get("id") != null){
                  WHERE(" id=#{id} ");
              }
              if(param.get("loginname") != null){
                  WHERE(" loginname=#{loginname} ");
              }
              if(param.get("password") != null){
                  WHERE(" password=#{password} ");
              }
              if(param.get("name") != null){
                  WHERE(" name=#{name} ");
              }
              if(param.get("sex") != null){
                  WHERE(" sex=#{sex} ");
              }
              if(param.get("age") != null){
                  WHERE(" age=#{age} ");
              }
              if(param.get("phone") != null){
                  WHERE( " phone=#{phone} ");
              }
              if(param.get("sal")!= null){
                  WHERE(" sal=#{sal} ");
              }
              if(param.get("state")!= null){
                  WHERE(" state=#{state} ");
              }
            }
        }.toString();
    }

    /**
     * 传递Employee
     * @param employee
     * @return
     */
    public String selectWithEmployee(Employee employee){
        return new SQL(){
            {
                SELECT("*");
                FROM("t_employee");
                if(employee.getId() != null){
                    WHERE(" id=#{id} ");
                }
                if(employee.getLoginname() != null){
                    WHERE(" loginname=#{loginname} ");
                }
                if(employee.getPassword() != null){
                    WHERE(" password=#{password} ");
                }
                if(employee.getName() != null){
                    WHERE(" name=#{name} ");
                }
                if(employee.getSex() != null){
                    WHERE(" sex=#{sex} ");
                }
                if(employee.getAge() != null){
                    WHERE(" age=#{age} ");
                }
                if(employee.getPhone() != null){
                    WHERE( " phone=#{phone} ");
                }
                if(employee.getSal() != null){
                    WHERE(" sal=#{sal} ");
                }
                if(employee.getState() != null){
                    WHERE(" state=#{state} ");
                }
            }
        }.toString();
    }

    public String insertEmployee(Employee employee){
        return  new SQL(){
            {
                INSERT_INTO("t_employee");
                if(employee.getLoginname() != null){
                   VALUES("loginname","#{loginname}");
                }
                if(employee.getPassword() != null){
                    VALUES("password","#{password}");
                }
                if(employee.getName() != null){
                    VALUES("name","#{name}");
                }
                if(employee.getSex() != null){
                   VALUES("sex","#{sex}");
                }
                if(employee.getAge() != null){
                   VALUES("age","#{age}");
                }
                if(employee.getPhone() != null){
                   VALUES("phone","#{phone}");
                }
                if(employee.getSal() != null){
                    VALUES("sal","#{sal}");
                }
                if(employee.getState() != null){
                    VALUES("state","#{state}");
                }
            }
        }.toString();
    }

    public String updateEmployee(Employee employee){
        return new SQL(){
            {
                UPDATE("t_employee");
                if(employee.getLoginname() != null){
                    SET(" loginname=#{loginname} ");
                }
                if(employee.getPassword() != null){
                    SET(" password=#{password} ");
                }
                if(employee.getName() != null){
                    SET(" name=#{name} ");
                }
                if(employee.getSex() != null){
                    SET(" sex=#{sex} ");
                }
                if(employee.getAge() != null){
                    SET(" age=#{age} ");
                }
                if(employee.getPhone() != null){
                    SET( " phone=#{phone} ");
                }
                if(employee.getSal() != null){
                    SET(" sal=#{sal} ");
                }
                if(employee.getState() != null){
                    SET(" state=#{state} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }

    public String deleteEmployee(Employee employee ){
        return  new SQL(){
            {
                DELETE_FROM("t_employee");
                if(employee.getId() != null){
                    WHERE(" id=#{id} ");
                }
                if(employee.getLoginname() != null){
                    WHERE(" loginname=#{loginname} ");
                }
                if(employee.getPassword() != null){
                    WHERE(" password=#{password} ");
                }
                if(employee.getName() != null){
                    WHERE(" name=#{name} ");
                }
                if(employee.getSex() != null){
                    WHERE(" sex=#{sex} ");
                }
                if(employee.getAge() != null){
                    WHERE(" age=#{age} ");
                }
                if(employee.getPhone() != null){
                    WHERE( " phone=#{phone} ");
                }
                if(employee.getSal() != null){
                    WHERE(" sal=#{sal} ");
                }
                if(employee.getState() != null){
                    WHERE(" state=#{state} ");
                }
            }
        }.toString();
    }
}
