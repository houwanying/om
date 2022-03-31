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
 * @Time: 2021/6/11 9:45
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "ViewStudentFormServlet",urlPatterns = "/ViewStudentFormServlet")
public class ViewStudentFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/StudentMainForm.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
