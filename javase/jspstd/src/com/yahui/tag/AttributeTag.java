package com.yahui.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class AttributeTag extends TagSupport {
	private String name;		//接收属性的名称
	private String scope;		//接收属性的范围
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public int doStartTag()
		throws JspException
	{
		Object value = null;
		if("page".equals(this.scope)){
			value =  super.pageContext.getAttribute(this.name,PageContext.PAGE_SCOPE);
		}
		else  if("request".equals(this.scope)){
			value = super.pageContext.getRequest().getAttribute(this.name);
		}
		else if("session".equals(this.scope)){
			value = super.pageContext.getSession().getAttribute(this.name);
		}
		else if("application".equals(this.scope)){
			value =  super.pageContext.getAttribute(this.name,PageContext.APPLICATION_SCOPE);
		}
		
		if(value==null){
			return TagSupport.SKIP_BODY;			//跳过标签体
		}
		else{
			return TagSupport.EVAL_BODY_INCLUDE;	//执行标签体
		}
	}
}
