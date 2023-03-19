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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 接收用户数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //  封装用户对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        // 2 调用mapper 根据用户名查询用户对象
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
        User u = mapper.selectByUsername(username);

        // 3 判断用户对象是否为null
        if(u==null){
            //用户名不存在，添加用户
            mapper.add(user);
            //提交事务
            sqlSession.commit();
            // 释放资源
            sqlSession.close();
        }else {
            //用户名存在，提示用户
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<h1>该用户名已存在</h1>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
