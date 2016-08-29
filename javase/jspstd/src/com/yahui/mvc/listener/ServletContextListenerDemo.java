package com.yahui.mvc.listener;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class ServletContextListenerDemo implements ServletContextListener{
	/**
	 * 只要是容器的关闭或者启动都会触发这两个方法
	 */
	public void contextInitialized(ServletContextEvent event){
		System.out.println("容器初始化--->"+event.getServletContext().getContextPath());
	}
	
	public void contextDestroyed(ServletContextEvent event){
		System.out.println("容器销毁--->"+event.getServletContext().getContextPath());
	}
}
