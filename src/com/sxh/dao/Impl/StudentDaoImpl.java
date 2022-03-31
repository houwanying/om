package com.sxh.dao.Impl;

import com.sxh.dao.StudentDao;
import com.sxh.pojo.Student;
import com.sxh.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Name: StudentDaoImpl
 * @Description:
 * @Time: 2021/6/15 9:04
 * @Author-Email: 1175166781@qq.com
 */
public class StudentDaoImpl implements StudentDao {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    @Override
    public int ifhasTitle(String studentId) {
        String str="select titleId from studentinfo where studentId=?";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            ps.setObject(1,studentId);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("titleId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public int chooseTitle(String studentId, String teacherId, Integer titleId) {
        String sql = "update studentinfo set teacherId=?,titleId=? where studentId=?";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(sql);
            ps.setObject(1,teacherId);
            ps.setObject(2,titleId);
            ps.setObject(3,studentId);

            int rs = ps.executeUpdate();

            if (rs == 1){
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public int delTitle(String studentId) {
        String sql = "update studentinfo set teacherId='无',titleId=0 where studentId=?";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(sql);

            ps.setObject(1,studentId);

            int rs = ps.executeUpdate();

            if (rs == 1){
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public String getTname(int titleId) {
        String str="select name from titleinfo where titleId=?";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            ps.setObject(1,titleId);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return null;
    }

    @Override
    public int submitMyProject(String studentId, String src) {
        String sql = "update studentinfo set src=? where studentId=?";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(sql);

            ps.setObject(1,src);
            ps.setObject(2,studentId);

            int rs = ps.executeUpdate();

            if (rs == 1){
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return 0;
    }
}
