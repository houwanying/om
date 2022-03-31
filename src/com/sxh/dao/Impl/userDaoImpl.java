package com.sxh.dao.Impl;

import com.sxh.dao.userDao;
import com.sxh.pojo.Admin;
import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;
import com.sxh.pojo.Title;
import com.sxh.utils.DBUtil;
import com.sxh.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Name: userDaoImpl
 * @Description:
 * @Time: 2021/6/9 16:07
 * @Author-Email: 1175166781@qq.com
 */
public class userDaoImpl implements userDao {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    @Override
    public Admin selectAllAdmin(String name, String password) {
        Admin admin = null;
        String str="select * from s_admin where name=? and password=?";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            ps.setObject(1,name);
            ps.setObject(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                String n = rs.getString("name");
                String passwd = rs.getString("password");
                admin = new Admin(n,passwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return admin;
    }

    @Override
    public Teacher selectAllTeacher(String name, String password) {
        Teacher teacher = new Teacher();
        String str="select * from s_teacher where name=? and password=?";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            ps.setObject(1,name);
            ps.setObject(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                teacher.setTname(rs.getString("name"));
                teacher.setPassword(rs.getString("password"));
                teacher.setTeacherId(rs.getString("teacherId"));
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return null;
    }

    @Override
    public Student selectAllStudent(String name, String password) {
        Student student = new Student();
        String str="select * from s_student left join studentinfo on s_student.studentId=studentinfo.studentId where s_student.name=? and password=?";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            ps.setObject(1,name);
            ps.setObject(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                student.setStudentId(rs.getString("studentId"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setTitleId(rs.getInt("titleId"));
                student.setSrc(rs.getString("src"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return null;
    }

    @Override
    public List<Object> selectTeacherList() {
        List<Object> list = new ArrayList<>();
        String str="select * from teacherinfo";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            rs = ps.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setTeacherId(rs.getString("teacherId"));
                teacher.setTname(rs.getString("tname"));
                teacher.setTage(rs.getInt("tage"));
                teacher.setTsex(rs.getString("tsex"));
                teacher.setTdept(rs.getString("tdept"));
                teacher.setTel(rs.getString("tel"));
                teacher.setQQ(rs.getString("QQ"));
                teacher.setProfessional(rs.getString("professional"));
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return list;
    }

    @Override
    public List<Object> selectTeacherList(String page, String limit) {
        List<Object> list = new ArrayList<>();
        String str="select * from teacherinfo limit ?,?";
        int page1 = Integer.parseInt(page);
        int limit1 = Integer.parseInt(limit);
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            ps.setObject(1,(page1-1)*limit1);
            ps.setObject(2,limit1);
            rs = ps.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setTeacherId(rs.getString("teacherId"));
                teacher.setTname(rs.getString("tname"));
                teacher.setTage(rs.getInt("tage"));
                teacher.setTsex(rs.getString("tsex"));
                teacher.setTdept(rs.getString("tdept"));
                teacher.setTel(rs.getString("tel"));
                teacher.setQQ(rs.getString("QQ"));
                teacher.setProfessional(rs.getString("professional"));
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return list;
    }

    @Override
    public int countTeacher() {
        String str="select count(*) as sum from teacherinfo";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("sum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public int insertStudent(String name, String password, String id) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        //先插入第一条数据
        String sql1 = "insert into s_student(name,password,studentId) values(?,?,?)";
        PreparedStatement ps = dbUtil.getPreparedStatement(sql1);
        ps.setString(1,name);
        ps.setString(2,password);
        ps.setString(3,id);
        int rs1 = ps.executeUpdate();

        if (rs1 == 1){
            dbUtil.commit();
            //插入第二条数据
            String sql2 = "insert into studentinfo(name,studentId) values(?,?)";
            PreparedStatement ps2 = dbUtil.getPreparedStatement(sql2);
            ps2.setString(1,name);
            ps2.setString(2,id);
            int rs2 = ps2.executeUpdate();

            if (rs2 == 1){
                dbUtil.commit();
                return 1;
            }else {
                dbUtil.connectionRollback();
                return 0;
            }


        }else {
            dbUtil.connectionRollback();
            return 0;
        }


    }

    @Override
    public int insertTeacher(String name, String password, String id) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        //先插入第一条数据
        String sql1 = "insert into s_teacher(name,password,teacherId) values(?,?,?)";
        PreparedStatement ps = dbUtil.getPreparedStatement(sql1);
        ps.setString(1,name);
        ps.setString(2,password);
        ps.setString(3,id);
        int rs1 = ps.executeUpdate();

        if (rs1 == 1){
            dbUtil.commit();
            //插入第二条数据
            String sql2 = "insert into teacherinfo(teacherId,tname) values(?,?)";
            PreparedStatement ps2 = dbUtil.getPreparedStatement(sql2);
            ps2.setString(1,id);
            ps2.setString(2,name);
            int rs2 = ps2.executeUpdate();

            if (rs2 == 1){
                dbUtil.commit();
                return 1;
            }else {
                dbUtil.connectionRollback();
                return 0;
            }


        }else {
            dbUtil.connectionRollback();
            return 0;
        }
    }

    @Override
    public List<Object> selectTitleList(String page, String limit) {
        List<Object> list = new ArrayList<>();
        String str="select * from titleinfo limit ?,?";
        int page1 = Integer.parseInt(page);
        int limit1 = Integer.parseInt(limit);
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            ps.setObject(1,(page1-1)*limit1);
            ps.setObject(2,limit1);
            rs = ps.executeQuery();
            while (rs.next()){
               Title title = new Title();
               title.setTitleId(rs.getInt("titleId"));
               title.setName(rs.getString("name"));
               title.setType(rs.getString("type"));
               title.setTeacherId(rs.getString("teacherId"));
               list.add(title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return list;
    }

    @Override
    public int countTitle() {
        String str="select count(*) as sum from titleinfo";
        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("sum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public List<Object> selectTitleListLikeName(String select) {
        List<Object> list = new ArrayList<>();
        String str="select * from titleinfo where name like '%"+select+"%'";

        try {
            conn= JdbcUtils.getConnection();
            //这两条语句不能写反
            ps = conn.prepareStatement(str);
            rs = ps.executeQuery();
            while (rs.next()){
                Title title = new Title();
                title.setTitleId(rs.getInt("titleId"));
                title.setName(rs.getString("name"));
                title.setType(rs.getString("type"));
                title.setTeacherId(rs.getString("teacherId"));
                list.add(title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return list;
    }
}
