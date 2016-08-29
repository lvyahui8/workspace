package com.yahui.servlet.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class HttpSessionDemoServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) {
		HttpSession ses = req.getSession();
		System.out.println("Session id->"+ses.getId());
		ses.setAttribute("name","lvyahui");
		System.out.println("姓名："+ses.getAttribute("name"));
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		this.doGet(req, resp);
	}
}
