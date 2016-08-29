package com.yahui.mvc.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListenerDemo implements ServletContextAttributeListener{

	/**
	 * 当setAttribute时调用此方法
	 */
	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("增加属性："+scab.getName()+" 属性内容："+scab.getValue());
	}

	/**
	 * 但刷新页面时调用此方法
	 */
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("移除属性："+scab.getName()+" 属性内容："+scab.getValue());
	}
	
	/**
	 * 当removeAttribute时调用此方法
	 */
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("替换属性："+scab.getName()+" 属性内容："+scab.getValue());
	}
	

}
