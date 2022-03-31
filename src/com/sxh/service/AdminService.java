package com.sxh.service;

import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;

/**
 * @Name: AdminService
 * @Description:
 * @Time: 2021/6/11 9:23
 * @Author-Email: 1175166781@qq.com
 */
public interface AdminService {
    public int AddStudent(Student student);
    public int AddTeacher(Teacher teacher);
}
