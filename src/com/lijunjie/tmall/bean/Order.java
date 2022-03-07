package com.lijunjie.tmall.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lijunjie.tmall.service.OrderService;

public class Order implements Serializable {
	private String orderCode;
	private String address;
	private String post;
	private String receiver;
	private String mobile;
	private String userMessage;
	private String createDate;
	private String payDate;
	private String deliveryDate;
	private String confirmDate;
	private User user;
	private Integer id;
	private List<OrderItem> orderItems;
	private float total;
	private Integer totalNumber;
	private String status;

	public Order() {
		super();
	}

	public Order(String orderCode, String address, String post, String receiver, String mobile, String userMessage,
			String createDate, String payDate, String deliveryDate, String confirmDate, User user, Integer id,
			List<OrderItem> orderItems, float total, Integer totalNumber, String status) {
		super();
		this.orderCode = orderCode;
		this.address = address;
		this.post = post;
		this.receiver = receiver;
		this.mobile = mobile;
		this.userMessage = userMessage;
		this.createDate = createDate;
		this.payDate = payDate;
		this.deliveryDate = deliveryDate;
		this.confirmDate = confirmDate;
		this.user = user;
		this.id = id;
		this.orderItems = orderItems;
		this.total = total;
		this.totalNumber = totalNumber;
		this.status = status;
	}
	
	 //把对应的Status信息转换成中文
    public String getStatusDesc() {
        String desc = "未知";
        switch (status) {
            case OrderService.waitPay:
                desc = "待付款";
                break;
            case OrderService.waitDelivery:
                desc = "待发货";
                break;
            case OrderService.waitConfirm:
                desc = "待收货";
                break;
            case OrderService.waitReview:
                desc = "等评价";
                break;
            case OrderService.finish:
                desc = "完成";
                break;
            case OrderService.delete:
                desc = "刪除";
                break;
            default:
                desc = "未知";
        }
        return desc;
    }
	
	

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderCode=" + orderCode + ", address=" + address + ", post=" + post + ", receiver=" + receiver
				+ ", mobile=" + mobile + ", userMessage=" + userMessage + ", createDate=" + createDate + ", payDate="
				+ payDate + ", deliveryDate=" + deliveryDate + ", confirmDate=" + confirmDate + ", user=" + user
				+ ", id=" + id + ", orderItems=" + orderItems + ", total=" + total + ", totalNumber=" + totalNumber
				+ ", status=" + status + "]";
	}
	
	

}
