package com.company.DesignPatterns.structural.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductConverterAdapter {
	//this class adapts the product to return a single product list


	public static List<WarehouseProduct> convertStoreProductToWareHouseProduct(List<StoreProduct> productList) {
		List<WarehouseProduct> convertedProducts = new ArrayList<>();
		productList.forEach((product) -> {
			WarehouseProduct prod = new WarehouseProduct(
					product.getProductName(),
					product.getProductExpiryDate(),
					product.getShippingPrice(),
					product.getSalePrice()
			);
			convertedProducts.add(prod);
		});
		return convertedProducts;
	}

	public static List<StoreProduct> convertWareHouseProductsToStoreProducts(List<WarehouseProduct> productLists) {
		List<StoreProduct> convertedProducts = new ArrayList<>();
		productLists.forEach((product) -> {
			StoreProduct storeProduct = new StoreProduct(
					getIdString(),
					product.getProductName(),
					product.getProductShippingPrice(),
					product.getProductSalePrice(),
					product.getProductShelfLife()
			);
			storeProduct.setId(getIdString());
			convertedProducts.add(storeProduct);
		});

		return convertedProducts;
	}


	public static String getIdString() {
		return String.valueOf(new Random(10000).nextInt());
	}
}
