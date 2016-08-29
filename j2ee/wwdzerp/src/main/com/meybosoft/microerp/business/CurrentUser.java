package com.meybosoft.microerp.business;

import com.easyjf.web.tools.ActiveUser;
import com.easyjf.web.tools.IActiveUser;

/**
 * ��ǰ�����û����ö���ͨ��һ��ThreadLocal����ŵ�ǰ�̵߳Ļ�û����Ӷ�ʹ�ÿ����û���֤ģ����Ը��Ӷ���
 * 
 * @author ëΰ
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
