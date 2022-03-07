package com.lijunjie.tmall.service.impl;


import com.lijunjie.tmall.bean.ProductImage;
import com.lijunjie.tmall.bean.ProductImageExample;
import com.lijunjie.tmall.dao.ProductImageMapper;
import com.lijunjie.tmall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    ProductImageMapper productImageMapper;

    @Override
    public void add(ProductImage pi) {
        productImageMapper.insert(pi);
    }

    @Override
    public void delete(int id) {
        productImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ProductImage pi) {
        productImageMapper.updateByPrimaryKeySelective(pi);
    }

    @Override
    public ProductImage get(int id) {
        return productImageMapper.selectByPrimaryKey(id);
    }

    @Override
    //根据产品id和图片类型查询对应的产品图片集合
    public List list(int pid, String type) {
        ProductImageExample example = new ProductImageExample();
        example.createCriteria()
                .andPidEqualTo(pid)
                .andTypeEqualTo(type);
      //  example.setOrderByClause("id desc");
        return productImageMapper.selectByExample(example);
    }
}
