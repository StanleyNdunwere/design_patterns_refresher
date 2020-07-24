package com.company.DesignPatterns.creational_patterns.factory;

public class MainRocketBooster extends SpaceShipEngineComponent {
	private int thrust;

	public MainRocketBooster(int thrust) {
		this.thrust = 4000;
	}

	@Override
	int getCost() {
		return 200 * thrust;
	}


}
