package com.yangzhuo.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加载资源
        System.out.println("加载中");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //释放资源
        System.out.println("释放资源中");
    }
}
