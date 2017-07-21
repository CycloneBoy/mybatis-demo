package com.cycloneboy.mybatis.entity;

import java.io.Serializable;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public class Employee implements Serializable{
    private Integer id;
    private String loginname;
    private String password;
    private String name;
    private String sex;
    private Integer age;
    private String phone;
    private Double sal;
    private String state;

    public Employee() {
    }

    public Employee(Integer id, String loginname, String password, String name, String sex, Integer age, String phone, Double sal, String state) {
        this.id = id;
        this.loginname = loginname;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.sal = sal;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", sal=" + sal +
                ", state='" + state + '\'' +
                '}';
    }
}
