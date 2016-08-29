package org.lyh.happyhome.index.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.lyh.happyhome.category.service.CategoryService;
import org.lyh.happyhome.category.vo.Category;
import org.lyh.happyhome.product.service.ProductService;
import org.lyh.happyhome.product.vo.Product;

import java.util.List;

/**
 * 首页执行的Action
 * @author lvyahui
 *
 */
public class IndexAction extends ActionSupport {
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * 首页执行的method
	 */
	public String execute(){
		//查询一级分类
		List<Category> categories = this.categoryService.findAll();
		//因为每个页面都有一级分类，所以为了更快，直接存到session中
		ActionContext.getContext().getSession().put("categories",categories);

		//查询热门商品
		List<Product> products = this.productService.findHot();
		//保存到值栈
		System.out.println(products);
		ActionContext.getContext().getValueStack().set("products",products);
		return "index";
	}
}
