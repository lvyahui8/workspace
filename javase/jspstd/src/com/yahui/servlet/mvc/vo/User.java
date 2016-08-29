package com.yahui.servlet.mvc.vo;

public class User {
	private String userid;
	private String name;
	private String password;
	
	public void setUserId(String userid){
		this.userid = userid;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getUserId(){
		return this.userid;
	}
	public String getName(){
		return this.name;
	}
	public String getPassword(){
		return this.password;
	}
}
