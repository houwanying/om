package com.sxh.dao;

import com.sxh.pojo.Student;
import com.sxh.pojo.Title;

import java.util.List;

/**
 * @Name: TeacherDao
 * @Description:
 * @Time: 2021/6/11 15:52
 * @Author-Email: 1175166781@qq.com
 */
public interface TeacherDao {

    public int addTitle(Title title);
    public List<Object> selectMyStudent(String page, String limit, String teacherId);

    int editGrade(Student student);

}
