package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Employee;
import com.cycloneboy.mybatis.provider.EmployeeDynaSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface EmployeeMapper {

    // 动态查询
    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "selectWithParam")
    public List<Employee> selectWithParam(Map<String,Object> param);

    // 动态查询
    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "selectWithEmployee")
    public List<Employee> selectWithEmployee(Employee employee);

    // 动态插入
    @InsertProvider(type = EmployeeDynaSqlProvider.class,method = "insertEmployee")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int insertEmployee(Employee employee);

    // 动态更新
    @UpdateProvider(type = EmployeeDynaSqlProvider.class,method = "updateEmployee")
    public  void updateEmployee(Employee employee);

    @DeleteProvider(type = EmployeeDynaSqlProvider.class,method = "deleteEmployee")
    public void deleteEmployee(Employee employee);
}
