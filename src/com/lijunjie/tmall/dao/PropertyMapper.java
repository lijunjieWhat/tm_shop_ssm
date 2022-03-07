package com.lijunjie.tmall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lijunjie.tmall.bean.Category;
import com.lijunjie.tmall.bean.Property;
import com.lijunjie.tmall.bean.PropertyExample;

@Repository
public interface PropertyMapper {
	
	
	public Category queryCategoryBycid(Integer cid);
	
	
	
	
	//houtai
	int deleteByPrimaryKey(Integer id);

    int insert(Property record);

    int insertSelective(Property record);

    List<Property> selectByExample(PropertyExample example);

    Property selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}
