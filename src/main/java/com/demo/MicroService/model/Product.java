package com.demo.MicroService.model;

import org.springframework.stereotype.Component;

@Component
public class Product{

	private Integer productId;
	private String productName;
	private String productType;
	
	public Product(){}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/*@Override
	public String toString() {
		return "Product [Id=" + productId + ", ProductName=" + productName
				+ ", ProductType=" + productType + "]";
	}*/
	 
}
