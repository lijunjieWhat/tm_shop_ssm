package com.lijunjie.tmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijunjie.tmall.bean.Review;
import com.lijunjie.tmall.dao.ReviewMapper;
import com.lijunjie.tmall.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public Integer addReview(Review review) {
		// TODO Auto-generated method stub
		return reviewMapper.addReview(review);
	}

}
