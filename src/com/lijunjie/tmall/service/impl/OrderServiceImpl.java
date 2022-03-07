package com.lijunjie.tmall.service.impl;

import com.lijunjie.tmall.bean.Order;
import com.lijunjie.tmall.bean.OrderExample;
import com.lijunjie.tmall.bean.User;
import com.lijunjie.tmall.dao.OrderMapper;
import com.lijunjie.tmall.service.OrderService;
import com.lijunjie.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserService userService;
    
	@Override
	public Integer addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.addOrder(order);
	}

	@Override
	public Integer updateOrderByOid(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.updateOrderByOid(order);
	}
    
    
	@Override
	public List<Order> queryUserAllOrders(User user, String status) {
		// TODO Auto-generated method stub
		return orderMapper.queryUserAllOrders(user, status);
	}
    
	@Override
	public Order queryOrderByOid(Integer oid) {
		// TODO Auto-generated method stub
		return orderMapper.queryOrderByOid(oid);
	}
    
    
    
    //后台

    @Override
    public void add(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order get(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List list() {
        OrderExample example = new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> result = orderMapper.selectByExample(example);
        setUser(result);
        return result;
    }

    public void setUser(List<Order> orders) {
        for (Order order : orders) {
            setUser(order);
        }
    }

    public void setUser(Order order) {
    	System.out.println(order.getUser());
        int uid = order.getUser().getId();
        User user = userService.get(uid);
        order.setUser(user);
    }



	


}
