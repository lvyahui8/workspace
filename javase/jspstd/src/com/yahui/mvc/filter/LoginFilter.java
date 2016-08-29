package com.yahui.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	public void init(FilterConfig config) 
		throws ServletException
	{
		
	}
	
	public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain)
		throws ServletException,IOException
	{
		//session属于http协议范畴
		//登录过滤
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession ses = request.getSession();
		if(ses.getAttribute("userid")!=null){
			chain.doFilter(req, resp);
		}
		else{
			request.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	
	public void destroy(){
		
	}
}
