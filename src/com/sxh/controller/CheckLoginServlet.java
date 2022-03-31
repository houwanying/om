package com.sxh.controller;

import com.sxh.pojo.Admin;
import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;
import com.sxh.service.LoginService;
import com.sxh.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Name: ${NAME}
 * @Description:
 * @Time: 2021/6/9 16:40
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "CheckLoginServlet",urlPatterns = "/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private LoginService loginService = new LoginServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name = request.getParameter("name");
       String password = request.getParameter("password");
       String entity = request.getParameter("entity");

       if (entity.equals("管理员")){
           Admin admin;
           try {
               admin = loginService.selectAllAdmin(name,password);
               System.out.println("admin:===>" + admin.toString());
               if (admin != null){
                   response.getWriter().write("success");
                   HttpSession session = request.getSession();
                   session.setAttribute("admin",admin);
               }else {
                   response.getWriter().write("fail");
               }
           }catch (Exception e){
               e.printStackTrace();
           }


       }else if (entity.equals("教师")){
           Teacher teacher;
           try {
               teacher = loginService.selectAllTeacher(name,password);
               if (teacher != null){
                   response.getWriter().write("success");
                   HttpSession session = request.getSession();
                   session.setAttribute("teacher",teacher);
               }else {
                   response.getWriter().write("fail");
               }
           }catch (Exception e){
               e.printStackTrace();
           }


       }else if (entity.equals("学生")){
           Student student;
           try {
               student = loginService.selectAllStudent(name,password);
               if (student != null){
                   response.getWriter().write("success");
                   HttpSession session = request.getSession();
                   session.setAttribute("student",student);
               }else {
                   response.getWriter().write("fail");
               }
           }catch (Exception e){
               e.printStackTrace();
           }

       }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
