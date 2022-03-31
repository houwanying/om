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
 * @Time: 2021/6/15 8:46
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "choose",urlPatterns = "/choose")
public class choose extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String studentId = request.getParameter("studentId");
        String teacherId = request.getParameter("teacherId");
        Integer titleId = Integer.parseInt(request.getParameter("titleId"));

        int a = studentDao.ifhasTitle(studentId);
        if (a != 0){
            //已有选题
            response.getWriter().write("您已有选题:"+a);
        }else {
            //还没有选题
            int b = studentDao.chooseTitle(studentId,teacherId,titleId);
            if (b == 1){
                response.getWriter().write("选题成功!选题为：" +titleId);
            }else {
                response.getWriter().write("选题失败");
            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
