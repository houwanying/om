package com.sxh.controller;

import com.sxh.dao.Impl.TeacherDaoImpl;
import com.sxh.dao.TeacherDao;
import com.sxh.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Name: ${NAME}
 * @Description:
 * @Time: 2021/6/11 17:22
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "editGrade",urlPatterns = "/editGrade")
public class editGrade extends HttpServlet {
    private TeacherDao teacherDao = new TeacherDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String grade = request.getParameter("grade");
        Student student = new Student();
        student.setStudentId(studentId);
        student.setGrade(Integer.parseInt(grade));

        int i = teacherDao.editGrade(student);
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
