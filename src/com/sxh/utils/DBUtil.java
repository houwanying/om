package com.sxh.utils;

import java.sql.*;

/**
 * @Name: DBUtil
 * @Description:
 * @Time: 2021/6/10 16:24
 * @Author-Email: 1175166781@qq.com
 */
public class DBUtil {

    private static String url ="jdbc:mysql://localhost:3306/g_design1?serverTimezone=UTC";
    private static String user ="root";
    private static String password ="123456";
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstmt;

    //第一步：建立驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //连接数据库
    private void openConnection(){
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚
    public void connectionRollback(){
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交
    public void commit(){
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Statement
    public Statement getStatement(){
        openConnection();
        try {
            stat = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stat;
    }

    //Statement
    public PreparedStatement getPreparedStatement(String sql){
        openConnection();
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }


}
