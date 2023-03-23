package com.yangzhuo.web.filter;

import com.yangzhuo.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 1 判断session中是否有User
        HttpServletRequest req= (HttpServletRequest) request;
        HttpSession session = req.getSession();
        //判断访问资源的路径是否和登录注册相关
        String[] urls={"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet","/selectUserServlet"};
        //获取当前访问的资源路径
        String url = req.getRequestURL().toString();
        //循环判断
        for (String s : urls) {
            if(url.contains(s)){
                //找到要放行的路径
                //放行
                chain.doFilter(request, response);
                return;
            }
        }

        User user = (User) session.getAttribute("user");
        //判断user是否为null
        if(user!=null){
            //登陆过了
            //放行
            chain.doFilter(request, response);
        }else{
            //没有登陆,跳转到登录界面
            req.setAttribute("login_msg","您尚未登陆");
            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
