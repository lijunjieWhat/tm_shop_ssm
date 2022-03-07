package com.lijunjie.tmall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lijunjie.tmall.bean.Category;
import com.lijunjie.tmall.bean.Product;
import com.lijunjie.tmall.bean.ProductExample;
import com.lijunjie.tmall.bean.ProductImage;
import com.lijunjie.tmall.bean.Review;
import com.lijunjie.tmall.bean.User;

@Repository
public interface ProductMapper {

	public Product queryProductById(Integer pid);
	
	public Category queryCategoryBycid(Integer cid);
	
	public List<ProductImage> querySingleImageByPidAndType(Integer pid);
	
	public List<ProductImage> queryDetailImageByPidAndType(Integer pid);
	
	public List<Review> queryReviewsByPid(Integer pid);
	
	public User queryUserByUid(Integer uid);
	
	public List<Product> search(String keyword);
	
	
	//后台
	int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}
