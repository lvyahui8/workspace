package com.yahui.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CheckServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException
	{
		System.out.println("doGet");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		String userid = req.getParameter("userid");
		PrintWriter pt = resp.getWriter();
		if("lvyahui".equals(userid)){
			pt.print("true");//一定不要写println
		}
		else{
			pt.print("false");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);  
	}
	
	
}
