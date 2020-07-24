package com.company.DesignPatterns;

import com.company.DesignPatterns.creational_patterns.builder.PizzaOrder;
import com.company.DesignPatterns.creational_patterns.factory.SpaceShip;
import com.company.DesignPatterns.creational_patterns.factory.SpaceShipFactory;
import com.company.DesignPatterns.creational_patterns.factory.SpaceShipType;
import com.company.DesignPatterns.creational_patterns.prototype.AlienDNA;
import com.company.DesignPatterns.creational_patterns.singleton.SingletonCarEngineParts;

public class Main {

	public static void main(String[] args) {

		//Singleton pattern
		SingletonCarEngineParts parts = SingletonCarEngineParts.getInstance();
		SingletonCarEngineParts parts1 = SingletonCarEngineParts.getInstance();

		if (parts == parts1) {
			System.out.println("This is the same object");
			System.out.println("Object 1: " + parts.toString());
			System.out.println("Object 2: " + parts1.toString());
		}


		//Builder pattern
		PizzaOrder.PizzaOrderBuilder pizzaBuilder = new PizzaOrder.PizzaOrderBuilder();
		PizzaOrder.PizzaOrderBuilder pizzaBuilder1 = new PizzaOrder.PizzaOrderBuilder();
		PizzaOrder order = pizzaBuilder.doughType("corn flour").flavorings("vanilla").meatType("peacock").build();
		PizzaOrder order1 = pizzaBuilder1.doughType("yam flour").meatType("goose meat").build();

		if (order.getSodaType() == null)
			System.out.println("Builder for order Success. 'sodaType' was not supplied in order");
		if (order1.getFlavorings() == null)
			System.out.println("Builder for order 1 Success. 'flavorings' was not supplied in order");
		if (order1.getSodaType() == null)
			System.out.println("Builder for order 1 Success. 'sodaType' was not supplied in order");


		//prototype pattern
		AlienDNA originalAlienDNA = new AlienDNA("adenine-40%", "guanine-10%", "cytosine-25%", "thymine-25%");
		System.out.println(originalAlienDNA.getCloneSuccessful());
		AlienDNA copyAlienDNA = (AlienDNA) originalAlienDNA.getPrototypeDNA();
		System.out.println(copyAlienDNA.getCloneSuccessful());


		//factory pattern
		SpaceShip spaceShip = SpaceShipFactory.getPreConfiguredSpaceShip(SpaceShipType.manned);
		SpaceShip spaceShip1 = SpaceShipFactory.getPreConfiguredSpaceShip(SpaceShipType.unManned);

		spaceShip.fireUpTheEngines();
		spaceShip.initiateLaunchSequence();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		spaceShip1.fireUpTheEngines();
		spaceShip1.initiateLaunchSequence();

		System.out.println(spaceShip1.giveListOfParts());
		System.out.println(spaceShip1.priceOfShip());

		System.out.println(spaceShip.giveListOfParts());
		System.out.println(spaceShip.priceOfShip());
	}
}
