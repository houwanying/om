package com.sxh.controller;

import com.sxh.dao.Impl.editDaoImpl;
import com.sxh.dao.editDao;
import com.sxh.pojo.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Name: ${NAME}
 * @Description:
 * @Time: 2021/6/10 14:10
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "EditTeacherServlet",urlPatterns = "/EditTeacherServlet")
public class EditTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止出现乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String teacherId = request.getParameter("teacherId");
        String tname = request.getParameter("tname");
        int tage = Integer.parseInt(request.getParameter("tage"));
        String tsex = request.getParameter("tsex");
        String tdept = request.getParameter("tdept");
        String tel = request.getParameter("tel");
        String qQ = request.getParameter("qQ");
        String professional = request.getParameter("professional");

        Teacher teacher = new Teacher(teacherId,tname,null,tage,tsex,tdept,tel,qQ,professional);

        editDao editDao = new editDaoImpl();
        int num = editDao.EditTeacher(teacher);
        if (num == 1){
            response.getWriter().write("success");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
