package com.meybosoft.microerp.action;

import java.lang.reflect.Method;

import com.easyjf.util.CommUtil;
import com.easyjf.web.IWebAction;
import com.easyjf.web.Module;
import com.easyjf.web.Page;
import com.easyjf.web.WebForm;

public class AbstractNakeAction implements IWebAction {
	private WebForm form;
	private Module module;
	public Page execute(WebForm form, Module module) throws Exception {
		Page forward=null;
		this.form=form;
		this.module=module;
		String command=CommUtil.null2String(form.get("easyJWebCommand"));
		if(!"".equals(command))
		{		
		Class[] paras=new Class[2];
		paras[0]=WebForm.class;
		paras[1]=Module.class;
		String cmd="do"+command.substring(0,1).toUpperCase()+command.substring(1);
		Method m=this.getClass().getMethod(cmd);
		if(m!=null)
		{
			Object[] objs=new Object[2];
			objs[0]=form;
			objs[1]=module;
			Object ret=m.invoke(this,objs);
			if(ret instanceof Page)forward=(Page)ret;				
		}
		else	
			throw new Exception("方法名称不正确,在"+this.getClass()+"中找不到"+cmd+"方法!请确认您页面中的easyJWebCommand参数值是否正确!");		
		}
		return forward;	
	}

}
