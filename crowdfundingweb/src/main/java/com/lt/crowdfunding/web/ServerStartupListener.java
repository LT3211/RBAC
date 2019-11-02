package com.lt.crowdfunding.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 当监听到web服务器启动则操作
 */
public class ServerStartupListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //将web应用名称(路径)保存到application范围中
        ServletContext application=servletContextEvent.getServletContext();
        String path=application.getContextPath();
        application.setAttribute("APP_PATH",path);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
