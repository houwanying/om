package com.sxh.dao;

import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;

/**
 * @Name: editDao
 * @Description:
 * @Time: 2021/6/10 14:15
 * @Author-Email: 1175166781@qq.com
 */
public interface editDao {
    public int EditTeacher(Teacher teacher);
    public int EditStudent(Student student);

}
