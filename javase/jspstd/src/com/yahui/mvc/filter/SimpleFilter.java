package com.yahui.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 过滤器经常使用在编码过滤和登录验证上
 */
public class SimpleFilter implements  Filter{

	//过滤器的生命周期跟servlet非常相似
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器销毁");
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain fc) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("执行过滤");
		System.out.println("执行doFilter方法之前");
		fc.doFilter(req, resp);//向下继续传递
		System.out.println("执行doFilter方法之后");
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String initParam = config.getInitParameter("ref");
		System.out.println("过滤器初始化，参数:"+initParam);
	}
}
