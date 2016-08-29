package com.yahui.jsp.bean;

import java.util.HashMap;
import java.util.Map;

public class Register {
	private String name;
	private String age;		//这种接受参数时，如果是用户自己输入，最好是string类型
	private String email;
	
	private Map<String,String> errors = null;

	public Register() {
		this.errors = new HashMap<String, String>();
	}
	
	public boolean isValidata(){
		boolean flag = true;
		
		if (!this.name.matches("\\w{6,15}")) {
			flag = false;
			this.name="";
			this.errors.put("errname", "用户名是6-15位的字母或者数字");
			
		}
		if(!this.email.matches("\\w+@\\w+.\\w+\\.?\\w*")){
			flag = false;
			this.email="";
			this.errors.put("erremail", "e-mail地址不合法");

		}
		if(!this.age.matches("\\d+")){
			flag = false;
			this.age="";
			this.errors.put("erreage", "年龄只能是数字");

		}
		return flag;
	}

	public String getErrorMsg(String errname){
		String value = this.errors.get(errname);
		return null ==  value ? "" : value ;
	}
	
	public String getName() {
		return null == name ? "" : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return null == age ? "" : age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return null == email ? "" : email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
