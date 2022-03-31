package com.sxh.service;

import com.sxh.pojo.Admin;
import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;

/**
 * @Name: LoginService
 * @Description:
 * @Time: 2021/6/9 16:34
 * @Author-Email: 1175166781@qq.com
 */
public interface LoginService {

    public Admin selectAllAdmin(String name, String password);
    public Teacher selectAllTeacher(String name, String password);
    public Student selectAllStudent(String name, String password);

}
