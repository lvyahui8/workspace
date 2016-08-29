package com.meybosoft.microerp.system;

import com.easyjf.web.tools.ActiveUser;
import com.meybosoft.microerp.business.CurrentUser;

import junit.framework.TestCase;

public class SystemRoleTest extends TestCase {
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		ActiveUser user = new ActiveUser();
		user.setUserName("csy");
		user.setPassword("111");
		CurrentUser.setCurrnetUser(user);
		super.setUp();
	}

	public void testCurrentUser() {
		System.out.println(CurrentUser.getCurrentUser().getUserName());
		Thread d = new Thread(new T());
		d.start();
	}

	class T implements java.lang.Runnable {
		public void run() {
			System.out.println(CurrentUser.getCurrentUser().getUserName());
		}
	}
}
