package com.yahui.mvc.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import java.io.IOException;
public class EncodingFilter implements Filter{
	private String charSet;
	public void init(FilterConfig config) throws ServletException{
		this.charSet = config.getInitParameter("charset");
	}
	
	public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain)
		throws ServletException,IOException
	{
		req.setCharacterEncoding(charSet);
		chain.doFilter(req, resp);
	}
	
	public void destroy(){
		
	}
}
