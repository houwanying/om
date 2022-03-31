package com.sxh.dao;

import com.sxh.pojo.Admin;
import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;

import java.sql.SQLException;
import java.util.List;

/**
 * @Name: userDao
 * @Description:
 * @Time: 2021/6/9 16:03
 * @Author-Email: 1175166781@qq.com
 */
public interface userDao {

    public Admin selectAllAdmin(String name, String password);
    public Teacher selectAllTeacher(String name, String password);
    public Student selectAllStudent(String name, String password);

    List<Object> selectTeacherList();
    List<Object> selectTeacherList(String page,String limit);

    int countTeacher();


    int insertStudent(String name, String password, String id) throws SQLException;

    int insertTeacher(String name, String password, String id) throws SQLException;

    List<Object> selectTitleList(String page, String limit);

    int countTitle();

    List<Object> selectTitleListLikeName(String select);

}
