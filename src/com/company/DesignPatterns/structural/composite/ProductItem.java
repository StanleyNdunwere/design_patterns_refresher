package com.company.DesignPatterns.structural.composite;

import java.util.Arrays;
import java.util.List;

public class ProductItem implements Package {

	private Package aPackage;
	private String productName;
	private int price;

	public ProductItem(String productName, int price) {
		this.productName = productName;
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	@Override
	public List<String> getProductsInPackage() {
		return Arrays.asList(this.productName);
	}
}
