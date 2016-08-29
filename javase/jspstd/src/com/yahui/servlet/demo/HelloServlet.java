package com.yahui.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 6737377551626051219L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pt = resp.getWriter();
		pt.println("<html>");
		pt.println("<head><title>LvYahui</title></head>");
		pt.println("<body>");
		pt.println("<h1>hello world</h1>");
		pt.println("</body>");
		pt.println("</html>");
		pt.close();
	}
}
