package com.yahui.jsp.demo;

public class Count {
	private int count = 0;
	
	public Count(){
		System.out.println("-======---init a hh---");
	}
	
	public int getCount(){
		return ++count;
	}
}
