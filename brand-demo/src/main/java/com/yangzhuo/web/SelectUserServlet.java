package com.yangzhuo.web;

import com.yangzhuo.mapper.UserMapper;
import com.yangzhuo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectUserServlet")
public class SelectUserServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 接收用户名
        String username = request.getParameter("username");
        // 2 调用service查询User对象
        boolean flag = service.selectByUserName(username);
        // 3 响应标记
        response.getWriter().write(""+flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
