package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Clazz;
import com.cycloneboy.mybatis.entity.Student;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/20.
 */
public interface StudentMapper {

    public Clazz selectClazzWithId(int id);

    public int getCount();

    public List<Student> selectStudent();

    public Student selectStudentWithId(int id);

    public List<Clazz> selectClazz();
}
