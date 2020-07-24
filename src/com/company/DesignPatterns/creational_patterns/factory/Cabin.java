package com.company.DesignPatterns.creational_patterns.factory;

public class Cabin extends SpaceShipEngineComponent {
	private int crewCapacity;

	public Cabin(int crewCapacity) {
		this.crewCapacity = crewCapacity;
	}

	@Override
	int getCost() {
		return 450 * crewCapacity;
	}
}
