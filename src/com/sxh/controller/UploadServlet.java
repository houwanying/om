package com.sxh.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Name: ${NAME}
 * @Description:
 * @Time: 2021/6/11 11:09
 * @Author-Email: 1175166781@qq.com
 */
@WebServlet(name = "UploadServlet",urlPatterns = "/UploadServlet")
@MultipartConfig//你现在用的是serlvet3新特性实现文件上传，要加上这个注解
public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止出现乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        JSONObject json = new JSONObject();
        //Map map = new HashMap<String,Object>();

        //存储路径
        String src = "/mylayui/web/upload";
        //放在数据库中
        String src2 = ".//upload/";
        //绝对路径
        String savePath = "F:\\燕山大学\\java_前端_资料\\mylayui\\web\\upload\\";

        //获取上传的文件集合
        Collection<Part> parts = request.getParts();

        //上传单个文件
        if (parts.size() == 1){
            Part part = request.getPart("file");
            System.out.println(part.toString());

            String header = part.getHeader("content-disposition");
            //获取文件名
            String fileName = part.getSubmittedFileName();
            System.out.println(fileName);

            part.write(savePath+ File.separator+ fileName);
            json.put("msg","上传成功");
            json.put("code",0);
            json.put("src",src+fileName);
            json.put("src2",src2+fileName);


        }else {
            for (Part part:parts) {
                String header = part.getHeader("content-disposition");
                //获取文件名
                //用这个part的方法即可
                String fileName = part.getSubmittedFileName();
                System.out.println(fileName);

                part.write(savePath+ File.separator+ fileName);
                json.put("msg","上传成功");
                json.put("code",0);
                json.put("src",src+fileName);
                json.put("src2",src2+fileName);

            }

        }
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 根据请求解析出文件名
     * @param header
     * @return
     */
    public String getFileName(String header){
        String[] temArr1 = header.split(",");
        //System.out.println("temArr1: "+ temArr1);
//数组越界异常
        String[] tepArr2 = temArr1[2].split("=");
        //System.out.println("tepArr2: "+ tepArr2);

        String fileName = tepArr2[1].substring(tepArr2[1].lastIndexOf("\\")+1).replaceAll("\"","");
        //System.out.println("filename: " + fileName);

        return fileName;
    }



}
