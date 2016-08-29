package com.meybosoft.microerp.dao;

import com.easyjf.web.tools.EasyDBODAO;
import com.easyjf.web.tools.IDAO;
import junit.framework.TestCase;

abstract class BaseEasyDBODaoTest extends TestCase {
	protected IDAO dao;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.dao = EasyDBODAO.getInstance();
		// EasyDBODAO.getInstance().getDb().setAutoCommit(false);
	}
}
