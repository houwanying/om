package com.sxh.controller;

import com.sxh.pojo.Student;
import com.sxh.service.AdminService;
import com.sxh.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Name: ${NAME}
 * @Description:
 * @Time: 2021/6/11 9:07
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "AddStudentServlet",urlPatterns = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String password = request.getParameter("password");
        String clazz = request.getParameter("clazz");

        Student student = new Student();
        student.setStudentId(studentId);
        student.setName(name);
        student.setSex(sex);
        student.setPassword(password);
        student.setClazz(clazz);

        int i = adminService.AddStudent(student);
        if (i == 1){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("fail");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
