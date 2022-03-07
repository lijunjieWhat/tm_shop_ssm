package com.lijunjie.tmall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lijunjie.tmall.bean.Category;
import com.lijunjie.tmall.bean.CategoryExample;
import com.lijunjie.tmall.bean.Product;
import com.lijunjie.tmall.bean.ProductImage;
@Repository
public interface CategoryMapper {

	/**
	 * 查询所有的类别
	 * @return
	 */
	public List<Category> queryAllCategories();
	
	public Product queryProductsByCid(Integer cid);
	
	public ProductImage queryFirstProductImageByPid(Integer pid);
	
	
	
	//后台
	 int deleteByPrimaryKey(Integer id);

	    int insert(Category record);

	    int insertSelective(Category record);

	    List<Category> selectByExample(CategoryExample example);

	    Category selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Category record);

	    int updateByPrimaryKey(Category record);
}
