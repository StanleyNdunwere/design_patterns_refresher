package com.company.DesignPatterns.creational_patterns.factory;

public class MannedSpaceShip extends SpaceShip {


	public MannedSpaceShip(Cabin cabin, MainRocketBooster booster) {
		this.cabin = cabin;
		this.mainRocketBooster = booster;
		this.nameOfShip = "Manned Ship - Casandra ";

	}

	@Override
	public int priceOfShip() {
		return this.cabin.getCost() + this.mainRocketBooster.getCost();
	}

	@Override
	public String giveListOfParts() {
		return "Parts of " + this.nameOfShip + "\n1. Cabin\n2. Main Rocket Booster";
	}

}
