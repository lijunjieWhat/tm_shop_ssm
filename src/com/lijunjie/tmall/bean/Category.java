package com.lijunjie.tmall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 分类表
 * 
 * @author 李俊杰
 *
 */
public class Category implements Serializable {
	private String name;
	private Integer id;
	// 一个类别对应多个商品
	List<Product> products;

	public Category() {
		super();
	}

	public Category(String name, Integer id, List<Product> products) {
		super();
		this.name = name;
		this.id = id;
		this.products = products;
	}

	public Category(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", id=" + id + ", products=" + products + "]";
	}

}
