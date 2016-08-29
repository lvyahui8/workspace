package com.meybosoft.microerp.business;

import com.easyjf.web.tools.ActiveUser;
import com.easyjf.web.tools.IActiveUser;

/**
 * 当前操作用户，该对象通过一个ThreadLocal来存放当前线程的活动用户，从而使得可以用户验证模块可以更加独立
 * 
 * @author 毛伟
 * 
 */
public class CurrentUser {
	private static ThreadLocal currentUser = new CurrentUserThreadLocal();

	public static void setCurrnetUser(IActiveUser user) {
		currentUser.set(user);
	}

	public static IActiveUser getCurrentUser() {
		IActiveUser user = (IActiveUser) currentUser.get();
		return user;
	}

	private static class CurrentUserThreadLocal extends ThreadLocal {
		protected synchronized Object initialValue() {
			return new ActiveUser();
		}
	}
}
