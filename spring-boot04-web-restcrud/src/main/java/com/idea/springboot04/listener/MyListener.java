package com.idea.springboot04.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web服务器启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web服务器关闭");
    }
}
