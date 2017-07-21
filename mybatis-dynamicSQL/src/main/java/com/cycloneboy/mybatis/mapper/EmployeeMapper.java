package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface EmployeeMapper {

    public List<Employee> selectEmployeeByIdLike(HashMap<String,Object> params);

    public List<Employee> selectEmployeeChoose(HashMap<String,Object> params);

    public List<Employee> selectEmployeeLike(HashMap<String,Object> params);

    public Employee selectEmployeeWithId(Integer id);

    public void updateEmployeeIfNecessary(Employee employee);

    public List<Employee> selectEmployeeIn(List<Integer> ids);

    public List<Employee> selectEmployeeLikeName(Employee employee);

}
