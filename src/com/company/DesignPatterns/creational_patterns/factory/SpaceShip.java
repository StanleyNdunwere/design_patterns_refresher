package com.company.DesignPatterns.creational_patterns.factory;

import java.util.Timer;
import java.util.TimerTask;

public abstract class SpaceShip {
	String nameOfShip;
	boolean isInOrbit = false;
	Cabin cabin;
	MainRocketBooster mainRocketBooster;

	public abstract int priceOfShip();

	public abstract String giveListOfParts();

	public void fireUpTheEngines() {
		System.out.println("Engines up, captain : Awaiting Launch Sequence");
	}

	public void initiateLaunchSequence() {
		System.out.println("All Crews Ready. Launch initiation sequence started. " +
				"\nYour Spaceship: " + nameOfShip + "will begin Lift-off in: \n");
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int countDown = 5;

			@Override
			public void run() {
				System.out.println(countDown);
				countDown -= 1;
				if (countDown < 0) {
					cancel();
					System.out.println("To Infinity and beyond!\n");
					isInOrbit = true;
				}
			}
		}, 500, 500);
	}

}
