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
 * @Time: 2021/6/15 9:26
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "del",urlPatterns = "/del")
public class del extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String studentId = request.getParameter("studentId");
        String teacherId = request.getParameter("teacherId");
        Integer titleId = Integer.parseInt(request.getParameter("titleId"));

        int a = studentDao.ifhasTitle(studentId);
        if (a != 0){
            //已有选题,继续判断是否可退选
            if ( a == titleId){
                int b = studentDao.delTitle(studentId);
                if (b == 1)
                 response.getWriter().write("退选成功！");
            }else {
                response.getWriter().write("无效点击！");
            }

        }else {
            //还没有选题 不可退选
            response.getWriter().write("未有选题！不可退选");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
