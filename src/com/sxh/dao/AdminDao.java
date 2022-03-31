package com.sxh.dao;

import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;

/**
 * @Name: AdminDao
 * @Description:
 * @Time: 2021/6/11 9:14
 * @Author-Email: 1175166781@qq.com
 */
public interface AdminDao {

    public int AddStudent(Student student);
    public int AddTeacher(Teacher teacher);

}
