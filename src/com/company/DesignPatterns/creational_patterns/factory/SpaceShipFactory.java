package com.company.DesignPatterns.creational_patterns.factory;

import java.util.Timer;
import java.util.TimerTask;

public class SpaceShipFactory {

	public static SpaceShip getPreConfiguredSpaceShip(SpaceShipType type) {
		switch (type) {
			case unManned:
				return new UnMannedSpaceShip(new MainRocketBooster(4000));
			case manned:
			default:
				return new MannedSpaceShip(new Cabin(5), new MainRocketBooster(7000));
		}
	}

}


