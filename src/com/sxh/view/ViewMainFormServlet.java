package com.sxh.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Name: ${NAME}
 * @Description:
 * @Time: 2021/6/9 16:55
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "ViewMainFormServlet",urlPatterns = "/ViewMainFormServlet")
public class ViewMainFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/MainForm.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
