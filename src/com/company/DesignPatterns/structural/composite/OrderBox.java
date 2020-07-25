package com.company.DesignPatterns.structural.composite;

import com.company.DesignPatterns.structural.adapters.Product;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.List;

public class OrderBox implements Package {
	private List<Package> packages = new ArrayList<>();
	private String boxName;

	public OrderBox(String boxName) {
	}


	public String getBoxName() {
		return boxName;
	}

	public int getTotalPrice(){
		List<Integer> allPrices = new ArrayList<>();
		if (this.packages.isEmpty()) {
			System.out.println("Hello, there is nothing in your package: Price = 0.00");
		} else {
			for (Package p : this.packages) {
				allPrices.add(p.getPrice());
			}
		}
		int runningSum = 0;
		for (int price : allPrices) {
			runningSum += price;
		}
		return runningSum;
	}

	@Override
	public int getPrice() {
		return this.getTotalPrice();
	}

	public void addItemToPackage(Package pack) {
		packages.add(pack);
		System.out.println(packages.size() + " Total packages");

	}

	@Override
	public List<String> getProductsInPackage() {
		List<String> allProducts = new ArrayList<>();
		if (this.packages.isEmpty()) {
			System.out.println("Hello, there is nothing in your package");
		} else
			for (Package p : this.packages) {
				allProducts.addAll(p.getProductsInPackage());
			}

		return allProducts;
	}


}
