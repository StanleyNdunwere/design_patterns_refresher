package com.company.DesignPatterns.structural.decorator;

public class VegetableSandwich implements SandwichMaker {

	private Sandwich sandwich;
	public VegetableSandwich(Sandwich sandwich){
		this.sandwich =sandwich;
	}
	@Override
	public void addCondiments() {
		this.sandwich.addCondiments();
		System.out.println("Adding Pickle to sandwich");
	}

	@Override
	public void selectCondiments() {
		this.sandwich.selectCondiments();
		System.out.println("Selecting pickles to add to sandwich");
	}
}
