package com.cycloneboy.mybatis.mapper;

import com.cycloneboy.mybatis.entity.Clazz;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public interface ClazzMapper {

    //根据id 查询班级信息
    @Select("select * from t_clazz where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "code",property = "code"),
            @Result(column = "id",property = "students",
            many = @Many(select = "com.cycloneboy.mybatis.mapper.StudentMapper.selectStudentByClazzId",
                            fetchType = FetchType.LAZY))
    })
    Clazz selectById(Integer id);
}
