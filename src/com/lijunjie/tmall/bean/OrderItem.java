package com.lijunjie.tmall.bean;

import java.io.Serializable;

public class OrderItem implements Serializable {
	private Integer id;
	private Integer number;
	private Product product;
	private Order order;
	private User user;

	public OrderItem() {
		super();
	}

	public OrderItem(Integer id, Integer number, Product product, Order order, User user) {
		super();
		this.id = id;
		this.number = number;
		this.product = product;
		this.order = order;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", number=" + number + ", product=" + product + ", order=" + order + ", user="
				+ user + "]";
	}
	
	

}
