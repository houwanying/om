package com.sxh.controller;

import com.alibaba.fastjson.JSONObject;
import com.sxh.dao.Impl.userDaoImpl;
import com.sxh.dao.userDao;
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
 * @Time: 2021/6/11 9:54
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "SelectAllTitle",urlPatterns = "/SelectAllTitle")
public class SelectAllTitle extends HttpServlet {
    private userDao userDao = new userDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        //得到全部教师信息
        List<Object> list = userDao.selectTitleList(page,limit);


        //传递到前台
        if (list.size() > 0){
            Vo vo = new Vo();
            vo.setCode(0);
            vo.setMsg("success");
            vo.setCount(userDao.countTitle());
            vo.setData(list);
            //转换成json数据,传递到前台
            response.getWriter().write(JSONObject.toJSONString(vo));
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
