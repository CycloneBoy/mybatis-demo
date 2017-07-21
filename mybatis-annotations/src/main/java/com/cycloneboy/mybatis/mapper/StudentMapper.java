package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface StudentMapper {

    @Select("select * from t_student where clazz_id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "age",property = "age")
    })
    List<Student> selectStudentByClazzId(Integer id);
}
