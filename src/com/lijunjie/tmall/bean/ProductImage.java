package com.lijunjie.tmall.bean;

import java.io.Serializable;

public class ProductImage implements Serializable {

	private Integer id;
	private String type;
	private Product product;

	public ProductImage() {
		super();
	}

	public ProductImage(Integer id, String type, Product product) {
		super();
		this.id = id;
		this.type = type;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", type=" + type + "]";
	}




	
}
