package com.yahui.servlet.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;

@SuppressWarnings("serial")
public class LifeCycleServlet extends HttpServlet{

	/*
	 * 3种情况servlet会被销毁
	 * 1、容器关闭（服务器停止）
	 * 2、长时间不使用
	 * 3、通过调用了reload方法
	 */
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("---init----");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---get----");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---post----");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("---destroy----");
		try{
			Thread.sleep(3000);
		}
		catch(Exception e){
			
		}
	}

	/*
	 * 重写了这个方法之后，doGet和doPost方法就没用了（不光这些方法）。注意还有另外一个service方法
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("----service-----");
//	}
	
	
}
