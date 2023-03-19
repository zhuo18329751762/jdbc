package com.yangzhuo.web;

import com.yangzhuo.mapper.UserMapper;
import com.yangzhuo.pojo.User;
import com.yangzhuo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2 调用MyBatis完成查询
        //2.1 获取SqlSessionFactory对象
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //2.2 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3 获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //2.4 调用方法
        User user = mapper.select(username, password);
        //2.5 释放资源
        sqlSession.close();

        //获取对应字符输入流，并设置content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // 3 判断user是否为null
        if(user!=null){
            //登陆成功
            writer.write("<h1>登录成功</h1>");
        }else {
            //登陆失败
            writer.write("<h1>登录失败</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
