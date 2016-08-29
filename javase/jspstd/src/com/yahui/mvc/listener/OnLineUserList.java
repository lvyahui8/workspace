package com.yahui.mvc.listener;

import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineUserList implements ServletContextListener,HttpSessionAttributeListener,HttpSessionListener{

	private ServletContext app = null;
	
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		Set all = (Set) this.app.getAttribute("online");
		all.add(se.getValue());
		this.app.setAttribute("online", all);
		
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		Set all = (Set) this.app.getAttribute("online");
		all.remove(se.getSession().getAttribute("userid"));
		this.app.setAttribute("online", all);
	}

	public void attributeReplaced(HttpSessionBindingEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		this.app = sce.getServletContext();
		this.app.setAttribute("online", new TreeSet());//Tree  二叉排序，依据cmpaloer接口
		
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		Set all = (Set) this.app.getAttribute("online");
		all.remove(se.getSession().getAttribute("userid"));
		this.app.setAttribute("online", all);
	}

}
