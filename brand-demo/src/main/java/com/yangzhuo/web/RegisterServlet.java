package com.yangzhuo.web;

import com.yangzhuo.pojo.User;
import com.yangzhuo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取用户填写的验证码
        String checkCode = request.getParameter("checkCode");
        //获取程序生成的验证码
        HttpSession session = request.getSession();
        String checkCodeGen = (String)session.getAttribute("checkCodeGen");
        //比对
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            //不允许注册
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        // 2 调用service注册
        boolean flag = service.register(user);
        // 3 判断成功与否
        if(flag){
            //注册成功 跳转到登录界面
            request.setAttribute("register_msg","注册成功,请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            //注册失败 跳转到注册页面
            request.setAttribute("register_msg","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
