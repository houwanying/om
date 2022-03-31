package com.sxh.utils;

import java.sql.*;

/**
 * @Name: JdbcUtils
 * @Description:
 * @Time: 2020/5/17 19:53
 * @Author-Email: 1175166781@qq.com
 */
public class JdbcUtils {
    //连接需要用到的三元素
    private static String url ="jdbc:mysql://localhost:3306/g_design1?serverTimezone=UTC";
    private static String user ="root";
    private static String password ="123456";

    //第一步：建立驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //第二步：建立连接
    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(url, user, password);
    }

    //第六步：释放资源
    public static void free(ResultSet rs, Statement sm, Connection conn){
        try {
            if (rs != null)
              rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                if (sm != null)
                   sm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {

                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
