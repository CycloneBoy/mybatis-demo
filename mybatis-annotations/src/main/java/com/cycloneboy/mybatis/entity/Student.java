package com.cycloneboy.mybatis.entity;

import java.io.Serializable;

/**
 * Created by CycloneBoy on 2017/7/20.
 */
public class Student implements Serializable{
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Clazz clazz;

    public Student() {
    }

    public Student(Integer id, String name, String sex, Integer age, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.clazz = clazz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", clazz=" + clazz +
                '}';
    }
}
