package com.yahui.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class InputServlet extends HttpServlet {
	/*
	 * 覆写了doGet方法后，客户端能够处理get方式提交的请求
	 * 为了能够处理post请求 需要复写doPost方法
	 * 
	 */
	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String info = req.getParameter("info");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>lyhui</title></head>");
		out.println("<body>");
		out.println(info);
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	
}
