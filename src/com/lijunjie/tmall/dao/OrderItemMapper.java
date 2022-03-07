package com.lijunjie.tmall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lijunjie.tmall.bean.OrderItem;
import com.lijunjie.tmall.bean.OrderItemExample;
import com.lijunjie.tmall.bean.User;

@Repository
public interface OrderItemMapper {

	public Integer addCart(OrderItem orderItem);
	
	public OrderItem queryCartProductByPidAndUid(Integer pid,Integer uid);
	
	public Integer updateInCartProductNumber(OrderItem orderItem);
	
	public Integer queryCartProductNumber(User user);
	

	public List<OrderItem> queryCartByUid(Integer uid);
	
	public OrderItem queryOrderItemByOIid(Integer oiId);
	
	public Integer updateOid(OrderItem orderItem);
	public Integer addOrderitem(OrderItem orderItem);
	
	public List<OrderItem> queryOrderItemByOid(Integer oid);
	
	//后台
	int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    List<OrderItem> selectByExample(OrderItemExample example);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}
