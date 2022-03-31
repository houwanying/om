package com.sxh.dao.Impl;

import com.sxh.dao.editDao;
import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;
import com.sxh.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Name: editDaoImpl
 * @Description:
 * @Time: 2021/6/10 14:16
 * @Author-Email: 1175166781@qq.com
 */
public class editDaoImpl implements editDao {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;



    @Override
    public int EditTeacher(Teacher teacher) {
        String str="update teacherinfo set tname=?,tage=?,tsex=?,tdept=?,tel=?,QQ=?,professional=? where teacherId=?";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            ps.setObject(1,teacher.getTname());
            ps.setObject(2,teacher.getTage());
            ps.setObject(3,teacher.getTsex());
            ps.setObject(4,teacher.getTdept());
            ps.setObject(5,teacher.getTel());
            ps.setObject(6,teacher.getQQ());
            ps.setObject(7,teacher.getProfessional());
            ps.setObject(8,teacher.getTeacherId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public int EditStudent(Student student) {
        return 0;
    }
}
