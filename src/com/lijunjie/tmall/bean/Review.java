package com.lijunjie.tmall.bean;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable {

	private Integer id; // 对应数据库字段 id
	private String content; // 对应数据库字段 content，表示评价内容
	private String createDate; // 对应数据库字段 createDate，表示评价时间
	private User user; // 数据库字段 uid，外键约束 user 表的 id，评价和用户是多对一
	private Product product; // 数据库字段 pid，外键约束 product 表的 id，评价和产品是多对一

	public Review() {
		super();
	}

	public Review(Integer id, String content, String createDate, User user, Product product) {
		super();
		this.id = id;
		this.content = content;
		this.createDate = createDate;
		this.user = user;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + ", createDate=" + createDate + ", user=" + user
				+ ", product=" + product + "]";
	}

	
}
