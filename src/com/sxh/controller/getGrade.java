package com.sxh.controller;

import com.alibaba.fastjson.JSONObject;
import com.sxh.dao.Impl.TeacherDaoImpl;
import com.sxh.dao.TeacherDao;
import com.sxh.pojo.Vo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Name: ${NAME}
 * @Description:
 * @Time: 2021/6/11 17:08
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "getGrade",urlPatterns = "/getGrade")
public class getGrade extends HttpServlet {
    private TeacherDao teacherDao = new TeacherDaoImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherId = request.getParameter("teacherId");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        List<Object> list = teacherDao.selectMyStudent(page, limit, teacherId);
        response.setContentType("text/html;charset=UTF-8");
        Vo vo = new Vo();
        vo.setCode(0);
        vo.setMsg("success");
        vo.setCount(list.size());//没有查
        vo.setData(list);
        //转换成json数据,传递到前台
        response.getWriter().write(JSONObject.toJSONString(vo));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
