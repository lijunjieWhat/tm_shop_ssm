package com.lijunjie.tmall.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijunjie.tmall.bean.Category;
import com.lijunjie.tmall.bean.Product;
import com.lijunjie.tmall.bean.ProductExample;
import com.lijunjie.tmall.bean.ProductImage;
import com.lijunjie.tmall.dao.ProductMapper;
import com.lijunjie.tmall.service.CategoryService;
import com.lijunjie.tmall.service.ProductImageService;
import com.lijunjie.tmall.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductImageService productImageService;

	@Override
	public Product queryProductById(Integer pid) {
		// TODO Auto-generated method stub
		return productMapper.queryProductById(pid);
	}

	@Override
	public void add(Product p) {
		int cid = p.getCategory().getId();
		Category c = categoryService.get(cid);
		p.setCategory(c);
		productMapper.insert(p);

	}

	@Override
	public void delete(int id) {
		productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Product p) {
		productMapper.updateByPrimaryKeySelective(p);
	}

	@Override
	public Product get(int id) {
		Product p = productMapper.selectByPrimaryKey(id);
		setCategory(p);
		setFirstProductImage(p);
		return p;
	}

	@Override
	public List<Product> list(int cid) {
		ProductExample example = new ProductExample();
		example.createCriteria().andCidEqualTo(cid);
		example.setOrderByClause("id desc");
		List<Product> result = productMapper.selectByExample(example);
		Category c = categoryService.get(cid);
		setCategory(result);
		setFirstProductImage(result);

		return result;
	}

	public void setCategory(List<Product> ps) {
		for (Product p : ps)
			setCategory(p);
	}

	public void setCategory(Product p) {
		int cid = p.getCategory().getId();
		Category c = categoryService.get(cid);
		p.setCategory(c);
	}

	@Override
	public void setFirstProductImage(Product p) {// 根据pid和type取出productImage集合
		List<ProductImage> pis = productImageService.list(p.getId(), ProductImageService.type_single);
		if (!pis.isEmpty()) {
			ProductImage pi = pis.get(0);
			p.setFirstProductImage(pi);
		}
	}

	public void setFirstProductImage(List<Product> ps) {
		for (Product p : ps) {
			this.setFirstProductImage(p);
		}
	}

	@Override
	public List<Product> search(String keyword) {
		// TODO Auto-generated method stub
		return productMapper.search(keyword);
	}

}
