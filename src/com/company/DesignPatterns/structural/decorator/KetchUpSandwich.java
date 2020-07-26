package com.company.DesignPatterns.structural.decorator;

public class KetchUpSandwich implements SandwichMaker{

	private VegetableSandwich vegetable;

	public KetchUpSandwich(VegetableSandwich vegetable) {
		this.vegetable = vegetable;
	}

	@Override
	public void addCondiments() {
		this.vegetable.addCondiments();
		System.out.println("Adding ketchup to sandwich");
	}

	@Override
	public void selectCondiments() {
		this.vegetable.selectCondiments();
		System.out.println("Selecting ketchup brand to add to the sandwich");
	}

	public void statusOfSandwich(){
		System.out.println("Sandwich Complete!");
	}
}
