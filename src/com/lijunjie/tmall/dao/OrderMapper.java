package com.lijunjie.tmall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lijunjie.tmall.bean.Order;
import com.lijunjie.tmall.bean.OrderExample;
import com.lijunjie.tmall.bean.User;

@Repository
public interface OrderMapper {
	
	public Integer addOrder(Order order);
	public Integer updateOrderByOid(Order order);
	public List<Order> queryUserAllOrders(User user,String status);
	public Integer queryOrderProductNumber(Integer id);
	//后台
	Order queryOrderByOid(Integer oid);
	int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
