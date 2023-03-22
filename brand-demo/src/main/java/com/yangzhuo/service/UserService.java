package com.yangzhuo.service;

import com.yangzhuo.mapper.UserMapper;
import com.yangzhuo.pojo.User;
import com.yangzhuo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username,String password){
        /**
         * 登录方法
         */
        // 2 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4 执行方法
        User user = mapper.select(username, password);
        // 5 释放资源
        sqlSession.close();
        return user;
    }
    public boolean register(User user){
        /**
         * 注册方法
         */
        // 2 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if(u==null){
            //用户名不存在,注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u==null;

    }
}
