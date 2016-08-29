package com.meybosoft.microerp.business.impl;

import com.easyjf.web.tools.IDAO;

public abstract class AbstractDAOServiceSupport {
protected IDAO dao=com.easyjf.web.tools.EasyDBODAO.getInstance();
public IDAO getDao() {
	return dao;
}
public void setDao(IDAO dao) {
	this.dao = dao;
}
public void add(Object obj)
{
	this.dao.save(obj);
}
public void update(Object obj)
{
	this.dao.update(obj);
}
public void del(Object obj)
{
	this.dao.del(obj);
}
}
