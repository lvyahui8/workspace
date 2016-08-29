package org.lyh.happyhome.product.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.lyh.happyhome.product.vo.Product;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 */
public class ProductDao extends HibernateDaoSupport {
    public List<Product> findHot() {
        /*
        分页查询
         */

        //使用离线条件查询
        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        // 查询热门的商品，条件就是is_hot = 1
        criteria.add(Restrictions.eq("is_hot",1));
        //倒排序
        criteria.addOrder(Order.desc("pdate"));
        System.out.println(criteria);
        return  super.getHibernateTemplate().findByCriteria(criteria,0,10);
    }
}
