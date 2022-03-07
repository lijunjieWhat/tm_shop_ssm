package com.lijunjie.tmall.service;

import java.util.List;

import com.lijunjie.tmall.bean.Order;
import com.lijunjie.tmall.bean.OrderItem;
import com.lijunjie.tmall.bean.User;

public interface OrderItemService {

public Integer addCart(OrderItem orderItem);
	
	public OrderItem queryCartProductByPidAndUid(Integer pid,Integer uid);
	
	public Integer updateInCartProductNumber(OrderItem orderItem);
	
	public Integer queryCartProductNumber(User user);
	
	public List<OrderItem> queryCartByUid(Integer uid);
	

	public OrderItem queryOrderItemByOIid(Integer oiId);
	
	public Integer updateOid(OrderItem orderItem);
	public Integer addOrderitem(OrderItem orderItem);
	
	//后台
	
	 void add(OrderItem oi);

	    void delete(int id);

	    void update(OrderItem oi);

	    OrderItem get(int id);

	    List list();

	    void fill(List<Order> orders);

	    void fill(Order order);
}
