package com.lijunjie.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijunjie.tmall.bean.Category;
import com.lijunjie.tmall.bean.CategoryExample;
import com.lijunjie.tmall.dao.CategoryMapper;
import com.lijunjie.tmall.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> queryAllCategories() {
		// TODO Auto-generated method stub
		return categoryMapper.queryAllCategories();
	}

	
	///////////////
	@Override
    public List<Category> list() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);//按照这种写法传递一个example对象，这个对象指定按照id倒序查询
    }

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}
