package com.yahui.el.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yahui.el.vo.Dept;

public class ELServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException
	{
		Dept dept = new Dept();
		dept.setDeptno(10);
		dept.setDname("永州");
		dept.setLoc("城标");
		req.setAttribute("deptinfo", dept);
		
		List all = new ArrayList();
		for(int i=0;i<3;i++){
			Dept d= new Dept();
			d.setDeptno(11);
			d.setDname("sdjksd"+i);
			d.setLoc("城标"+i);
			all.add(d);
		}
		
		req.setAttribute("alldeptinfo", all);
		
		req.getRequestDispatcher("dept_info.jsp").forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException
	{
		this.doGet(req, resp);
		
	}
}
