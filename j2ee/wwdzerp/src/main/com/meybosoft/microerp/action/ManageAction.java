package com.meybosoft.microerp.action;

import com.easyjf.util.CommUtil;
import com.easyjf.web.ActionContext;
import com.easyjf.web.Module;
import com.easyjf.web.Page;
import com.easyjf.web.WebForm;
import com.easyjf.web.ajax.AjaxUtil;
import com.easyjf.web.tools.AbstractCmdAction;
import com.easyjf.web.tools.IActiveUser;
import com.meybosoft.microerp.business.LogicException;
import com.meybosoft.microerp.business.SystemUserService;
public class ManageAction extends AbstractCmdAction {
	private SystemUserService userService;	
	public void setUserService(SystemUserService userService) {
		this.userService = userService;
	}
	public Page doInit(WebForm form, Module module) {
		return module.findPage("login");
	}	
	public Page doLogout(WebForm form, Module module)
	{
		ActionContext.getContext().getSession().removeAttribute("user");
		return new Page("goto","/index.ejf","html");
	}
	public Page doExit(WebForm form, Module module)
	{
		ActionContext.getContext().getSession().removeAttribute("user");
		return new Page("goto","/exit.htm","html");
	}	
	
	public Page doShowLogin(WebForm form, Module module)
	{
		return module.findPage("login");
	}
	public Page doShowFirst(WebForm form, Module module)
	{
		return module.findPage("first");
	}

	public Page doLogin(WebForm form, Module module) throws Exception
	{
	
		Page page=null;	
		/*
		String randomCode=(String)ActionContext.getContext().getSession().getAttribute("rand");
		if(randomCode==null){
			form.addResult("msg","您没有登录,或者登录信息已经超时,请重新登录！");
			return doShowLogin(form,module);
		}	
		if(!randomCode.equals((String)form.get("randomCode")))
		{
			form.addResult("msg","验证码不正确，请重新输入！");
			return module.findPage("login");
		}*/
		String userName=CommUtil.null2String(form.get("userName"));
		String password=CommUtil.null2String(form.get("password"));		
		if(userName.equals("")|| password.equals(""))
		{
			form.addResult("msg","用户名或者密码不能为空，请重新输入！");
			return doShowLogin(form,module);
		}		
		try{
	//	System.out.println(ActionContext.getContext().getRequest().getRemoteAddr());
		IActiveUser user=userService.login(userName,password,ActionContext.getContext().getRequest().getRemoteAddr());		
		if(user!=null)
			{					
			ActionContext.getContext().getSession().setAttribute("user",user);//登录标志
			form.addResult("currentUserJson","SystemUserService.currentUser="+AjaxUtil.getJSON(user));
			page=module.findPage("main");
			}
		else
		{
			form.addResult("msg","用户名或者密码不正确，请重新输入！");
			page=doShowLogin(form,module);
		}
		}
		catch(LogicException e)
		{
			form.addResult("msg","用户名或者密码不正确，请重新输入！");
			page=doShowLogin(form,module);
			//e.printStackTrace();
		}
		return page;
	}
}
