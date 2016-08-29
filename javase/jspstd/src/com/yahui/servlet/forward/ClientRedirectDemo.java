package com.yahui.servlet.forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ClientRedirectDemo extends HttpServlet{
	public void doGet(HttpServletRequest req ,HttpServletResponse resp)
	throws ServletException,IOException{
		req.getSession().setAttribute("name", "lvyahui");
		req.setAttribute("info", "www.yahui.com");
		resp.sendRedirect("forward/get_info.jsp");
	}
	public void doPost(HttpServletRequest req ,HttpServletResponse resp)
			throws ServletException,IOException{
		this.doGet(req, resp);
	}
}
