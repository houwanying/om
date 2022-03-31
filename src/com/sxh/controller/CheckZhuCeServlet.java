package com.sxh.controller;

import com.sxh.dao.Impl.userDaoImpl;
import com.sxh.dao.userDao;
import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Name: ${NAME}
 * @Description:
 * @Time: 2021/6/10 16:09
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "CheckZhuCeServlet",urlPatterns = "/CheckZhuCeServlet")
public class CheckZhuCeServlet extends HttpServlet {
    private userDao userDao = new userDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String id = request.getParameter("id");
        String entity = request.getParameter("entity");
        Student student;
        Teacher teacher;

        if (entity.equals("学生")){
            student = userDao.selectAllStudent(name,password);
            if (student == null){
                //插入数据库中
                try {
                    int num = userDao.insertStudent(name,password,id);
                    if (num == 1){
                        response.getWriter().write("success");
                    }else {
                        response.getWriter().write("fail");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else {
                response.getWriter().write("fail");
            }

        }else if (entity.equals("教师")){
            teacher = userDao.selectAllTeacher(name,password);
            if (teacher == null){
                //插入数据库中
                try {
                    int num = userDao.insertTeacher(name,password,id);
                    if (num == 1){
                        response.getWriter().write("success");
                    }else {
                        response.getWriter().write("fail");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else {
                response.getWriter().write("fail");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
