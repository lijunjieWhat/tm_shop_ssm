package com.lijunjie.tmall.service;

import com.lijunjie.tmall.bean.Order;
import com.lijunjie.tmall.bean.User;

import java.util.List;

public interface OrderService {

	public Integer addOrder(Order order);
	public Integer updateOrderByOid(Order order);
	public List<Order> queryUserAllOrders(User user,String status);
	Order queryOrderByOid(Integer oid);
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    void add(Order order);

    void delete(int id);

    void update(Order order);

    Order get(int id);

    List list();

}
