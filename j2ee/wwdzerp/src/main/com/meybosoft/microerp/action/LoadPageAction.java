package com.meybosoft.microerp.action;

import com.easyjf.web.IWebAction;
import com.easyjf.web.Module;
import com.easyjf.web.Page;
import com.easyjf.web.WebForm;

public class LoadPageAction implements IWebAction {
	public Page execute(WebForm form, Module module) throws Exception {
		String url=(String)form.get("url");
		//System.out.println(url);
		return new Page(url,url,"template");
	}

}
