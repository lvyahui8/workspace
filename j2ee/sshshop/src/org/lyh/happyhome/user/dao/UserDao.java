package org.lyh.happyhome.user.dao;

import java.util.List;

import org.lyh.happyhome.user.vo.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 用户持久层代码
 * @author admin
 *
 */
public class UserDao extends HibernateDaoSupport{
	
	/**
	 * 按username查询是否有该用户
	 */
	public User findByUserName(String username){
		String hql = "from user where username = ?";
		List<User> res = (List<User> )this.getHibernateTemplate().find(hql,username);
		if(res!=null && res.size()>0){
			return res.get(0);
		}
		return null;
	}
}
