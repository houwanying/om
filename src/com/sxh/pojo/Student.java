package com.sxh.pojo;

import lombok.Data;

/**
 * @Name: Student
 * @Description:
 * @Time: 2021/6/9 15:49
 * @Author-Email: 1175166781@qq.com
 */

public class Student {
    private String studentId;
    private String name;
    private String password;
    private String sex;
    private int age;
    private String teacherId;
    private int grade;
    private String clazz;
    private int titleId;
    private String src;

    public Student() {
    }

    public Student(String studentId, String name, String password, String sex, int age, String teacherId, int grade, String clazz, int titleId) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.teacherId = teacherId;
        this.grade = grade;
        this.clazz = clazz;
        this.titleId = titleId;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }
}
