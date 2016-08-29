package com.yahui.servlet.demo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemoServlet extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse reps){
		ServletContext app = super.getServletContext();
		System.out.println("真实路径："+app.getRealPath("/"));
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse reps){
		this.doGet(req, reps);
	}
}
