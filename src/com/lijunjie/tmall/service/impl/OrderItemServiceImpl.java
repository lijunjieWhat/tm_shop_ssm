package com.lijunjie.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijunjie.tmall.bean.Order;
import com.lijunjie.tmall.bean.OrderItem;
import com.lijunjie.tmall.bean.OrderItemExample;
import com.lijunjie.tmall.bean.Product;
import com.lijunjie.tmall.bean.User;
import com.lijunjie.tmall.dao.OrderItemMapper;
import com.lijunjie.tmall.service.OrderItemService;
import com.lijunjie.tmall.service.ProductService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemMapper orderItemMapper;
	@Autowired
    ProductService productService;
	@Override
	public Integer addCart(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return orderItemMapper.addCart(orderItem);
	}

	@Override
	public OrderItem queryCartProductByPidAndUid(Integer pid, Integer uid) {
		// TODO Auto-generated method stub
		return orderItemMapper.queryCartProductByPidAndUid(pid, uid);
	}

	@Override
	public Integer updateInCartProductNumber(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return orderItemMapper.updateInCartProductNumber(orderItem);
	}

	@Override
	public Integer queryCartProductNumber(User user) {
		// TODO Auto-generated method stub
		return orderItemMapper.queryCartProductNumber(user);
	}

	@Override
	public List<OrderItem> queryCartByUid(Integer uid) {
		// TODO Auto-generated method stub
		return orderItemMapper.queryCartByUid(uid);
	}

	@Override
	public OrderItem queryOrderItemByOIid(Integer oiId) {
		// TODO Auto-generated method stub
		return orderItemMapper.queryOrderItemByOIid(oiId);
	}
	
	

	@Override
	public Integer updateOid(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return orderItemMapper.updateOid(orderItem);
	}

	@Override
	public Integer addOrderitem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return orderItemMapper.addOrderitem(orderItem);
	}
	
	//后台
	  @Override
	    public void add(OrderItem oi) {
	        orderItemMapper.insert(oi);
	    }

	    @Override
	    public void delete(int id) {
	        orderItemMapper.deleteByPrimaryKey(id);
	    }

	    @Override
	    public void update(OrderItem oi) {
	        orderItemMapper.updateByPrimaryKeySelective(oi);
	    }

	    @Override
	    public OrderItem get(int id) {
	        OrderItem result = orderItemMapper.selectByPrimaryKey(id);
	        setProduct(result);//为orderitem设置product属性，product属性是非数据库字段，多对一关系
	        return result;
	    }

	    @Override
	    public List list() {
	        OrderItemExample example = new OrderItemExample();
	        example.setOrderByClause("id desc");
	        return orderItemMapper.selectByExample(example);
	    }

	    @Override
	    public void fill(List<Order> orders) {
	        for (Order order : orders) {
	            fill(order);
	        }
	    }

	   
	    @Override
	    public void fill(Order order) {
	        OrderItemExample example = new OrderItemExample();
	        example.createCriteria().andOidEqualTo(order.getId());
	        example.setOrderByClause("id desc");
	        List<OrderItem> ois = orderItemMapper.selectByExample(example);
	        setProduct(ois);

	        float total = 0;
	        int totalNumber = 0;
	        for (OrderItem oi : ois) {
	            total += oi.getNumber() * oi.getProduct().getPromotePrice();
	            totalNumber += oi.getNumber();
	        }
	        order.setTotal(total);
	        order.setTotalNumber(totalNumber);
	        order.setOrderItems(ois);
	    }

	    public void setProduct(List<OrderItem> ois) {
	        for (OrderItem oi : ois) {
	            setProduct(oi);
	        }
	    }

	    public void setProduct(OrderItem oi) {
	        Product p = (Product) productService.get(oi.getProduct().getId());
	        oi.setProduct(p);

	    }


}
