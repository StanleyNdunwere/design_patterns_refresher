package com.company.DesignPatterns.creational_patterns.factory;

public class UnMannedSpaceShip extends SpaceShip {

	public UnMannedSpaceShip(MainRocketBooster booster) {
		this.mainRocketBooster = booster;
		this.nameOfShip = "unManned Ship - Okoronkwo ";
	}

	public int priceOfShip() {
		return this.mainRocketBooster.getCost();
	}

	public String giveListOfParts(){
		return  "Parts of " + this.nameOfShip + "\n1. Main Rocket Booster\n";
	}

}
