package com.yangzhuo.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Cookie
        // 1 获取Cookie数据
        Cookie[] cookies = request.getCookies();
        // 2 遍历数组
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if("username".equals(name)){
                String value = cookie.getValue();
                System.out.println("name: "+name);
                System.out.println("value: "+ URLDecoder.decode(value,"UTF-8"));
                break;
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
