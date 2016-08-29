package org.lyh.happyhome.category.service;

import org.lyh.happyhome.category.dao.CategoryDao;
import org.lyh.happyhome.category.vo.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2015/4/10.
 */
@Transactional
public class CategoryService {
    private CategoryDao categoryDao;
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> findAll() {
        return this.categoryDao.findAll();
    }
}

