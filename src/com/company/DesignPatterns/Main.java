package com.company.DesignPatterns;

import com.company.DesignPatterns.creational_patterns.builder.PizzaOrder;
import com.company.DesignPatterns.creational_patterns.factory.SpaceShip;
import com.company.DesignPatterns.creational_patterns.factory.SpaceShipFactory;
import com.company.DesignPatterns.creational_patterns.factory.SpaceShipType;
import com.company.DesignPatterns.creational_patterns.prototype.AlienDNA;
import com.company.DesignPatterns.creational_patterns.singleton.SingletonCarEngineParts;
import com.company.DesignPatterns.structural.adapters.Product;
import com.company.DesignPatterns.structural.adapters.ProductConverterAdapter;
import com.company.DesignPatterns.structural.adapters.StoreProduct;
import com.company.DesignPatterns.structural.adapters.WarehouseProduct;
import com.company.DesignPatterns.structural.bridge.RandomCodeCreator;
import com.company.DesignPatterns.structural.bridge.ReverseNumberDistorter;
import com.company.DesignPatterns.structural.bridge.SquareDistorter;
import com.company.DesignPatterns.structural.composite.OrderBox;
import com.company.DesignPatterns.structural.composite.ProductItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


		//Adapter pattern
		ArrayList<WarehouseProduct> wareHouseProducts = new ArrayList<>();
		ArrayList<StoreProduct> storeProducts = new ArrayList<>();

		WarehouseProduct product = new WarehouseProduct(
				"Biscuit",
				"10-10-2100",
				100,
				150
		);

		WarehouseProduct product1 = new WarehouseProduct(
				"Noodles",
				"10-09-2021",
				10,
				15
		);

		StoreProduct product3 = new StoreProduct(
				"1234",
				"Vitamin C",
				10,
				12,
				"15-08-2021"
		);

		StoreProduct product4 = new StoreProduct(
				"12444",
				"Remdesivir",
				2000,
				12,
				"19-08-2021"
		);

		wareHouseProducts.add(product);
		wareHouseProducts.add(product1);

		storeProducts.add(product4);
		storeProducts.add(product3);

		ArrayList<WarehouseProduct> wareHouseProductsList = new ArrayList<>();
		wareHouseProductsList.addAll(wareHouseProducts);
		//using the adapter
		wareHouseProductsList.addAll(ProductConverterAdapter.convertStoreProductToWareHouseProduct(storeProducts));

		ArrayList<StoreProduct> storeProductsList = new ArrayList<>();
		storeProductsList.addAll(storeProducts);
		//using the adapter
		storeProductsList.addAll(ProductConverterAdapter.convertWareHouseProductsToStoreProducts(wareHouseProducts));

		//bridge pattern
		SquareDistorter procedure = new SquareDistorter();
		ReverseNumberDistorter procedure1 = new ReverseNumberDistorter();

		RandomCodeCreator creator = new RandomCodeCreator(123343, 322020, procedure);
		RandomCodeCreator creator1 = new RandomCodeCreator(78842372, 3257248, procedure1);

		System.out.println(creator.getRandomCode());
		System.out.println(creator1.getRandomCode());


		//composite pattern - tree structure
		ProductItem fan = new ProductItem("Ceiling fan", 100);
		ProductItem screwDriver = new ProductItem("Screw Driver", 100);
		ProductItem pipeWrench = new ProductItem("Pipe Wrench", 100);

		OrderBox completeWorkTools = new OrderBox("Complete Work Tools");
		OrderBox onlyScrewDriver =  new OrderBox("Only Screw Driver");
		OrderBox pipeWrenchAndCeilingFan =  new OrderBox("Pipe Wrench + Ceiling Fan");
		onlyScrewDriver.addItemToPackage(screwDriver);
		pipeWrenchAndCeilingFan.addItemToPackage(pipeWrench);
		pipeWrenchAndCeilingFan.addItemToPackage(fan);

		completeWorkTools.addItemToPackage(onlyScrewDriver);
		completeWorkTools.addItemToPackage(fan);
		completeWorkTools.addItemToPackage(pipeWrench);
		completeWorkTools.addItemToPackage(screwDriver);
		completeWorkTools.addItemToPackage(pipeWrenchAndCeilingFan);

		System.out.println(completeWorkTools.getProductsInPackage().toString());
		System.out.println(completeWorkTools.getPrice());


	}
}
