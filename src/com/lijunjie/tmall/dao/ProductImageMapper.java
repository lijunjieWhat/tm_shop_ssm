package com.lijunjie.tmall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lijunjie.tmall.bean.ProductImage;
import com.lijunjie.tmall.bean.ProductImageExample;
@Repository
public interface ProductImageMapper {
	  int deleteByPrimaryKey(Integer id);

	    int insert(ProductImage record);

	    int insertSelective(ProductImage record);

	    List<ProductImage> selectByExample(ProductImageExample example);

	    ProductImage selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(ProductImage record);

	    int updateByPrimaryKey(ProductImage record);
}
