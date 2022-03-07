package com.lijunjie.tmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lijunjie.tmall.bean.Product;


public interface ProductService {

	public Product queryProductById(Integer pid);
	public List<Product> search(String keyword);
	
	//后台
	 void add(Product p);
	    void delete(int id);
	    void update(Product p);
	    Product get(int id);
	    List list(int cid);
	    void setFirstProductImage(Product p);
}
