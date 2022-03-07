package com.lijunjie.tmall.service;

import java.util.List;

import com.lijunjie.tmall.bean.Category;

public interface CategoryService {

	/**
	 * 查询所有的类别
	 * @return
	 */
	public List<Category> queryAllCategories();
	
	
	
	///////////////
	List<Category> list();
    void add(Category category);
    void delete(int id);

    Category get(int id);

    void update(Category category);
}
