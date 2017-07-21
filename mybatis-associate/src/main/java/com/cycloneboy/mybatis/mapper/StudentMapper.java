package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Student;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface StudentMapper {

    public Student selectStudentById(Integer id);

    public List<Student> selectStudentByClazzId(Integer id);
}
