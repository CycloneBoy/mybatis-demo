package com.cycloneboy.mybatis.entity;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/20.
 */
public class Clazz {
    private Integer id;
    private String code;
    private List<Student> students;


    public Clazz() {
    }

    public Clazz(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }



}
