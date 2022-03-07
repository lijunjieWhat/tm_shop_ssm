package com.lijunjie.tmall.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author 李俊杰
 *
 */
public class Product implements Serializable {
	private Integer id;
	private String name;
	private String subTitle;
	private float originalPrice;
	private float promotePrice;
	private Integer stock;
	private String createDate;
	private Integer reviewCount;
	private Integer saleCount;
	private ProductImage firstProductImage;
	private List<ProductImage> productImages;
	private List<ProductImage> productSingleImages;
	private List<ProductImage> productDetailImages;
	private Category category;
	private List<Review> reviews;

	public Product() {
		super();
	}

	
	public Product(Integer id, String name, String subTitle, float originalPrice, float promotePrice, Integer stock,
			String createDate, Integer reviewCount, Integer saleCount, ProductImage firstProductImage,
			List<ProductImage> productImages, List<ProductImage> productSingleImages,
			List<ProductImage> productDetailImages, Category category, List<Review> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.subTitle = subTitle;
		this.originalPrice = originalPrice;
		this.promotePrice = promotePrice;
		this.stock = stock;
		this.createDate = createDate;
		this.reviewCount = reviewCount;
		this.saleCount = saleCount;
		this.firstProductImage = firstProductImage;
		this.productImages = productImages;
		this.productSingleImages = productSingleImages;
		this.productDetailImages = productDetailImages;
		this.category = category;
		this.reviews = reviews;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public float getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}

	public float getPromotePrice() {
		return promotePrice;
	}

	public void setPromotePrice(float promotePrice) {
		this.promotePrice = promotePrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public ProductImage getFirstProductImage() {
		return firstProductImage;
	}

	public void setFirstProductImage(ProductImage firstProductImage) {
		this.firstProductImage = firstProductImage;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public List<ProductImage> getProductSingleImages() {
		return productSingleImages;
	}

	public void setProductSingleImages(List<ProductImage> productSingleImages) {
		this.productSingleImages = productSingleImages;
	}

	public List<ProductImage> getProductDetailImages() {
		return productDetailImages;
	}

	public void setProductDetailImages(List<ProductImage> productDetailImages) {
		this.productDetailImages = productDetailImages;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", subTitle=" + subTitle + ", originalPrice=" + originalPrice
				+ ", promotePrice=" + promotePrice + ", stock=" + stock + ", createDate=" + createDate
				+ ", reviewCount=" + reviewCount + ", saleCount=" + saleCount + ", firstProductImage="
				+ firstProductImage + ", productImages=" + productImages + ", productSingleImages="
				+ productSingleImages + ", productDetailImages=" + productDetailImages + ", category=" + category
				+ ", reviews=" + reviews + "]";
	}


	

}
