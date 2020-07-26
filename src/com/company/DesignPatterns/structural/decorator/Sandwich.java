package com.company.DesignPatterns.structural.decorator;

public class Sandwich implements SandwichMaker {

	public Sandwich() {
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding the bread to the Sandwich");
	}

	@Override
	public void selectCondiments() {
		System.out.println("Selecting the bread to add to the Sandwich");
	}
}
