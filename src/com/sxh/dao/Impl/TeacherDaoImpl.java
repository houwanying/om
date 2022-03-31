package com.sxh.dao.Impl;

import com.sxh.dao.TeacherDao;
import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;
import com.sxh.pojo.Title;
import com.sxh.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Name: TeacherDaoImpl
 * @Description:
 * @Time: 2021/6/11 15:53
 * @Author-Email: 1175166781@qq.com
 */
public class TeacherDaoImpl implements TeacherDao {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static PreparedStatement ps1 = null;
    private static PreparedStatement ps2 = null;
    private static ResultSet rs = null;

    @Override
    public int addTitle(Title title) {
        String sql1 = "insert into titleinfo(type,name,teacherId,src) values(?,?,?,?)";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps1 = conn.prepareStatement(sql1);
            ps1.setObject(1,title.getType());
            ps1.setObject(2,title.getName());
            ps1.setObject(3,title.getTeacherId());
            ps1.setObject(4,title.getSrc());
            int rs1 = ps1.executeUpdate();

            if (rs1 == 1){
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
    public List<Object> selectMyStudent(String page, String limit, String teacherId) {
        List<Object> list = new ArrayList<>();
        String str="select * from studentinfo where teacherId=? limit ?,?";
        int page1 = Integer.parseInt(page);
        int limit1 = Integer.parseInt(limit);
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            ps.setObject(1,teacherId);
            ps.setObject(2,(page1-1)*limit1);
            ps.setObject(3,limit1);
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getString("studentId"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setTitleId(rs.getInt("titleId"));
                student.setGrade(rs.getInt("grade"));

                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return list;
    }

    @Override
    public int editGrade(Student student) {
        String sql1 = "update studentinfo set grade=? where studentId=?";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps1 = conn.prepareStatement(sql1);
            ps1.setObject(1,student.getGrade());
            ps1.setObject(2,student.getStudentId());

            int rs1 = ps1.executeUpdate();

            if (rs1 == 1){
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps1,conn);
        }
        return 0;


    }
}
