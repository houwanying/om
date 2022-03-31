package com.sxh.controller;

import com.sxh.dao.Impl.StudentDaoImpl;
import com.sxh.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Name: ${NAME}
 * @Description:
 * @Time: 2021/6/15 10:09
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "submitMyProject",urlPatterns = "/submitMyProject")
public class submitMyProject extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String studentId = request.getParameter("studentId");
        String src = request.getParameter("src");

        int a = studentDao.submitMyProject(studentId,src);
        if (a == 1){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("fail");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
