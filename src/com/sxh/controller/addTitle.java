package com.sxh.controller;

import com.sxh.dao.Impl.TeacherDaoImpl;
import com.sxh.dao.TeacherDao;
import com.sxh.pojo.Title;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Name: ${NAME}
 * @Description:
 * @Time: 2021/6/11 15:52
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "addTitle",urlPatterns = "/addTitle")
public class addTitle extends HttpServlet {
    private TeacherDao teacherDao = new TeacherDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherId = request.getParameter("teacherId");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String src = request.getParameter("src");
        Title title = new Title();
        title.setTeacherId(teacherId);
        title.setName(name);
        title.setType(type);
        title.setSrc(src);

        int i = teacherDao.addTitle(title);
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
