package com.sxh.dao.Impl;

import com.sxh.dao.AdminDao;
import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;
import com.sxh.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Name: AdminDaoImpl
 * @Description:
 * @Time: 2021/6/11 9:15
 * @Author-Email: 1175166781@qq.com
 */
public class AdminDaoImpl implements AdminDao {
    private static Connection conn = null;
    private static PreparedStatement ps1 = null;
    private static PreparedStatement ps2 = null;
    private static ResultSet rs = null;

    @Override
    public int AddStudent(Student student) {
        String sql1 = "insert into s_student(name,password,studentId) values(?,?,?)";
        String sql2 = "insert into studentinfo(name,studentId) values(?,?)";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps1 = conn.prepareStatement(sql1);
            ps1.setObject(1,student.getName());
            ps1.setObject(2,student.getPassword());
            ps1.setObject(3,student.getStudentId());
            int rs1 = ps1.executeUpdate();

            ps2 = conn.prepareStatement(sql2);
            ps2.setObject(1,student.getName());
            ps2.setObject(2,student.getStudentId());
            int rs2 = ps2.executeUpdate();
            if (rs1 == 1 && rs2==1){
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps1,conn);
            JdbcUtils.free(rs,ps2,conn);
        }
        return 0;
    }

    @Override
    public int AddTeacher(Teacher teacher) {
        return 0;
    }
}
