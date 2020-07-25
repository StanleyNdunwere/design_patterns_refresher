package com.company.DesignPatterns.structural.adapters;

import java.util.Random;

public class StoreProduct extends Product {

	private String productName;
	private int shippingPrice;
	private int salePrice;
	private String productExpiryDate;

	public StoreProduct(String id, String productName, int shippingPrice, int salePrice, String productExpiryDate) {
		this.id = id;
		this.productName = productName;
		this.shippingPrice = shippingPrice;
		this.salePrice = salePrice;
		this.productExpiryDate = productExpiryDate;
	}

	public void setId(String id){
		if(this.id == null)
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public int getShippingPrice() {
		return shippingPrice;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public String getProductExpiryDate() {
		return productExpiryDate;
	}
}
