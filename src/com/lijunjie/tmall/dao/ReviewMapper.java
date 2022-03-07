package com.lijunjie.tmall.dao;

import org.springframework.stereotype.Repository;

import com.lijunjie.tmall.bean.Review;

@Repository
public interface ReviewMapper {
	
	public Integer addReview(Review review);

}
