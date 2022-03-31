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
 * @Time: 2021/6/11 10:16
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "SelectTitle",urlPatterns = "/SelectTitle")
public class SelectTitle extends HttpServlet {
    private com.sxh.dao.userDao userDao = new userDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String select = request.getParameter("select");

        //得到全部教师信息
        List<Object> list = userDao.selectTitleListLikeName(select);


        //传递到前台
        if (list.size() > 0){
            Vo vo = new Vo();
            vo.setCode(0);
            vo.setMsg("success");
            vo.setCount(list.size());
            vo.setData(list);
            //转换成json数据,传递到前台
            response.getWriter().write(JSONObject.toJSONString(vo));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
