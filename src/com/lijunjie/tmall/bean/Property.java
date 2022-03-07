package com.lijunjie.tmall.bean;

import java.io.Serializable;

/**
 * 属性实体类
 * 
 * @author 李俊杰
 *
 */
public class Property implements Serializable {
	private Integer id;
	private String name;
	// 例如 平板电脑 对应多个属性 如：品牌 ，制造商名称等
	private Category category;// 分类实体类

	public Property() {
		super();
	}

	public Property(Integer id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
	
	

}
