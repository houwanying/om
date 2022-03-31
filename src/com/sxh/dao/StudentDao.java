package com.sxh.dao;

/**
 * @Name: StudentDao
 * @Description:
 * @Time: 2021/6/15 8:50
 * @Author-Email: 1175166781@qq.com
 */
public interface StudentDao {


    int ifhasTitle(String studentId);

    int chooseTitle(String studentId, String teacherId, Integer titleId);

    int delTitle(String studentId);

    String getTname(int titleId);

    int submitMyProject(String studentId,String src);

}
