package com.meybosoft.microerp.action;

import com.easyjf.web.ActionContext;
import com.easyjf.web.Module;
import com.easyjf.web.WebForm;
import com.easyjf.web.tools.AbstractCrudAction;
import com.easyjf.web.tools.IActiveUser;
import com.easyjf.web.tools.IPageList;
public class BaseAction extends AbstractCrudAction {	
	public void doAfter(WebForm form, Module module) {
		// TODO Auto-generated method stub		
	}
//	Ö´ÐÐµÇÂ¼¼ìÑé
	public Object doBefore(WebForm form, Module module) {
		// TODO Auto-generated method stub
		//if(ActionContext.getContext().getSession().getAttribute("user")==null)return new Page("goto","/nologin.htm","html");
		return null;
	}
	public IPageList doQuery(WebForm form,int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object form2Obj(WebForm from) {
		// TODO Auto-generated method stub
		return null;
	}

	public void doInit(WebForm form, Module module) {
		// TODO Auto-generated method stub		
	}
	public IActiveUser getCurrentUser(WebForm form) {
		return (IActiveUser)ActionContext.getContext().getSession().getAttribute("user");
	}
}
