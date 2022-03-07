package com.lijunjie.tmall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lijunjie.tmall.bean.Property;
import com.lijunjie.tmall.bean.PropertyValue;
import com.lijunjie.tmall.bean.PropertyValueExample;
@Repository
public interface PropertyValueMapper {

	public List<PropertyValueMapper> queryPropertValue(Integer pid);

	public Property queryValue(Integer ptid);
	
	
	//后台
	int deleteByPrimaryKey(Integer id);

    int insert(PropertyValue record);

    int insertSelective(PropertyValue record);

    List<PropertyValue> selectByExample(PropertyValueExample example);

    PropertyValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PropertyValue record);

    int updateByPrimaryKey(PropertyValue record);
}
