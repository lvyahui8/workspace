package org.lyh.happyhome.product.service;

import org.lyh.happyhome.product.dao.ProductDao;
import org.lyh.happyhome.product.vo.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2015/4/10.
 */
@Transactional //事务
public class ProductService {
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findHot() {
        return this.productDao.findHot();
    }
}
