package com.yahui.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
	public int doStartTag() throws JspException{
		JspWriter out = super.pageContext.getOut();
		try{
			out.println("<b>hello world</b>");
		}catch(IOException e){
			e.printStackTrace();
		}
		return TagSupport.SKIP_BODY;
	} 
}
