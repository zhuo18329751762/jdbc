package com.yangzhuo.web;

import com.yangzhuo.pojo.User;
import com.yangzhuo.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello");
        // 1 获取用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //获取复选框数据
        String remember = request.getParameter("remember");
        // 2 调用service查询
        User user = service.login(username, password);
        // 3 判断
        if(user!=null){
            //登陆成功,跳转到查询所有的BrandServlet
            //判断用户是否勾选记住我
            if("1".equals(remember)){
                //勾选了，发送cookie
                // 1 创建cookie
                Cookie c_username=new Cookie("username",username);
                Cookie c_password=new Cookie("password",password);
                //设置cookie存活时间为一周
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                // 2 发送
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            //跳转
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        }else{
            //登陆失败
            //存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误");
            // 跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
