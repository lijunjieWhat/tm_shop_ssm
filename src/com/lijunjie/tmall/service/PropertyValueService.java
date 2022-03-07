package com.lijunjie.tmall.service;

import java.util.List;

import com.lijunjie.tmall.bean.Product;
import com.lijunjie.tmall.bean.PropertyValue;
import com.lijunjie.tmall.dao.PropertyValueMapper;

public interface PropertyValueService {
	public List<PropertyValueMapper> queryPropertValue(Integer pid);

	
	//后台
	 void init(Product p);
	    void update(PropertyValue pv);

	    //根据属性id和产品id获取对应的属性值
	    PropertyValue get(int ptid, int pid);
	    //根据产品id获取所有的属性值列表
	    List<PropertyValue> list(int pid);
}
