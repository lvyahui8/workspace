package org.lyh.happyhome.user.dao;

import org.lyh.happyhome.user.vo.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * 用户持久层代码
 * @author lvyahui
 *
 */
public class UserDao extends HibernateDaoSupport{
	
	/**
	 * 按username查询是否有该用户
	 */
	public User findByUserName(String username){
		String hql = "from User where username=?";//Hibernat对类查询，所以这个必须写的User
		List<User> list = super.getHibernateTemplate().find(hql,username);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public void save(User user){
		System.out.println(user);
		super.getHibernateTemplate().save(user);
	}

	public void update(User user){
		super.getHibernateTemplate().update(user);
	}


	public User finByCode(String code) {
		String hql = "from User where code=?";
		List<User> res = (List<User>) super.getHibernateTemplate().find(hql,code);
		return res != null ? res.get(0) : null;
	}

	public User login(User user) {
		String hql = "from User where username=? and password=? and state=?";
		List<User> res = super.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword(),1);
		return res != null ? res.get(0) : null;
	}

}
