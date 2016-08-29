package com.yahui.tag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

public class IterateBodyTag extends BodyTagSupport {
	private String name;
	private String scope;
	private String id;
	private Iterator it;
	
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		Object value = null;
		if("page".equals(this.scope)){
			value =  super.pageContext.getAttribute(this.name,PageContext.PAGE_SCOPE);
		}
		else  if("request".equals(this.scope)){
			value = super.pageContext.getRequest().getAttribute(this.name);
			//value =  super.pageContext.getAttribute(this.name,PageContext.REQUEST_SCOPE);
		}
		else if("session".equals(this.scope)){
			value = super.pageContext.getSession().getAttribute(this.name);
		}
		else if("application".equals(this.scope)){
			value =  super.pageContext.getAttribute(this.name,PageContext.APPLICATION_SCOPE);
		}
		if(value!=null && value instanceof List<?>){
			this.it = ((List<?>)value).iterator();
			if(it.hasNext()){
				super.pageContext.setAttribute(this.id, it.next());
				return BodyTagSupport.EVAL_BODY_BUFFERED;	//执行标签体
			}
		} 
		return BodyTagSupport.SKIP_BODY;			//跳过标签体
	}
	
	@Override
	public int doAfterBody() throws JspException{
		if(it.hasNext()){
			super.pageContext.setAttribute(this.id, it.next());
			return BodyTagSupport.EVAL_BODY_AGAIN;	//反复执行doAfterBody方法
		}
		else{
			return BodyTagSupport.SKIP_BODY;			//跳过标签体
		}
	}
	
	@Override
	public int doEndTag() throws JspException {//如果此方法没有编写，则没有输出
		// TODO Auto-generated method stub
		if(super.bodyContent !=null ){
			try{
				super.bodyContent.writeOut(super.getPreviousOut());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return BodyTagSupport.EVAL_PAGE;//正常执行完毕
	}
	
}
