package com.zhuoyang.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo11")
public class ServletDemo11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用request对象 获取请求数据
        String name = req.getParameter("name");
        //使用response对象 设置响应数据、
        resp.setHeader("content-type","text/html;charset=utf-8");
        resp.getWriter().write("<h1>"+name+",欢迎您!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post...");
    }
}
