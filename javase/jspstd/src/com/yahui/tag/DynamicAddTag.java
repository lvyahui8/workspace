package com.yahui.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DynamicAddTag extends SimpleTagSupport implements DynamicAttributes{

	private Map<String,Float> num = new HashMap<String,Float>();
	
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		Float sum = 0.0f;
		Iterator<Map.Entry<String, Float>> iter = this.num.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Float> value = iter.next();
			sum+=value.getValue();
		}
		super.getJspContext().getOut().write(sum+"");
	}

	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		// TODO Auto-generated method stub
		//取出设置的每一个属性都保存在动态集合里
		num.put(localName, Float.parseFloat(value.toString()));
	}
	
}
