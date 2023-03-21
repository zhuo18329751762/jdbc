package com.yangzhuo.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //发送Cookie
        String value="张三";
        //URL编码
        value = URLEncoder.encode(value, "UTF-8");
        System.out.println("存储数据: "+value);
        // 1 创建Cookie对象
        Cookie cookie = new Cookie("username",value);


        // 设置存活时间
        cookie.setMaxAge(60*60*24*7);
        // 2 发送Cookie.response
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
