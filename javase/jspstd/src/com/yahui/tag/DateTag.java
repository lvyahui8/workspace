package com.yahui.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class DateTag extends TagSupport {
	private String format;
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat(this.format);
		try {
			super.pageContext.getOut().write(sdf.format(new Date()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TagSupport.SKIP_BODY;
	}
	
}
