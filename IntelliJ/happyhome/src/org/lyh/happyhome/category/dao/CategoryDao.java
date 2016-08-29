package org.lyh.happyhome.category.dao;

import org.lyh.happyhome.category.vo.Category;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * 一级分类的业务层的持久对象
 */
public class CategoryDao extends HibernateDaoSupport{

    public List<Category> findAll() {
        String hql = "from Category";
        return super.getHibernateTemplate().find(hql);
    }
}
