package com.lijunjie.tmall.bean;

import java.io.Serializable;

/**
 * 属性值表
 * 
 * @author 李俊杰 
  *  存放属性值信息，如品牌是华为 重量是900g,颜色是红色
 */
public class PropertyValue implements Serializable {

	private Integer id;
	private String value;
	//
	private Product product;
	//
	private Property property;

	public PropertyValue() {
		super();
	}

	public PropertyValue(Integer id, String value, Product product, Property property) {
		super();
		this.id = id;
		this.value = value;
		this.product = product;
		this.property = property;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "PropertyValue [id=" + id + ", value=" + value + ", product=" + product + ", property=" + property + "]";
	}

	
	
}
