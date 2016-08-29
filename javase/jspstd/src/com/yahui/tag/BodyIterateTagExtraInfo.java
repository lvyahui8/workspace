package com.yahui.tag;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

public class BodyIterateTagExtraInfo extends TagExtraInfo {
	//变量支持类，可以将标签中设置的属性变为变量
	@Override
	public VariableInfo[] getVariableInfo(TagData data) {
		// TODO Auto-generated method stub
		return new VariableInfo[]{
				new VariableInfo(data.getId(), "java.lang.String", true, VariableInfo.NESTED)
		};
	}
	
	
}
