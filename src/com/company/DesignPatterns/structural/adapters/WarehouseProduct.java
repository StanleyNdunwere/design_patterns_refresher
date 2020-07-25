package com.company.DesignPatterns.structural.adapters;

public class WarehouseProduct {
	private String name;
	private String productShelfLife;
	private int productShippingPrice;
	private int productSalePrice;


	public WarehouseProduct(
			String productName,
			String productShelfNumber,
			int productShippingPrice,
			int productSalePrice
	) {
		this.name = productName;
		this.productShelfLife = productShelfNumber;
		this.productShippingPrice = productShippingPrice;
		this.productSalePrice = productSalePrice;
	}


	public String getProductName() {
		return name;
	}

	public String getProductShelfLife() {
		return productShelfLife;
	}

	public int getProductShippingPrice() {
		return productShippingPrice;
	}

	public int getProductSalePrice() {
		return productSalePrice;
	}


}
