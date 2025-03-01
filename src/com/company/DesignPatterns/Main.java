package com.company.DesignPatterns;

import com.company.DesignPatterns.behavioural.chain_of_responsibility.CarbonSteelHandler;
import com.company.DesignPatterns.behavioural.chain_of_responsibility.Steel;
import com.company.DesignPatterns.behavioural.chain_of_responsibility.SteelType;
import com.company.DesignPatterns.behavioural.command.FoundationLayer;
import com.company.DesignPatterns.behavioural.command.House;
import com.company.DesignPatterns.behavioural.command.HouseBuilder;
import com.company.DesignPatterns.behavioural.command.PaintHouse;
import com.company.DesignPatterns.creational_patterns.builder.PizzaOrder;
import com.company.DesignPatterns.creational_patterns.factory.SpaceShip;
import com.company.DesignPatterns.creational_patterns.factory.SpaceShipFactory;
import com.company.DesignPatterns.creational_patterns.factory.SpaceShipType;
import com.company.DesignPatterns.creational_patterns.prototype.AlienDNA;
import com.company.DesignPatterns.creational_patterns.singleton.SingletonCarEngineParts;
import com.company.DesignPatterns.structural.adapters.ProductConverterAdapter;
import com.company.DesignPatterns.structural.adapters.StoreProduct;
import com.company.DesignPatterns.structural.adapters.WarehouseProduct;
import com.company.DesignPatterns.structural.bridge.RandomCodeCreator;
import com.company.DesignPatterns.structural.bridge.ReverseNumberDistorter;
import com.company.DesignPatterns.structural.bridge.SquareDistorter;
import com.company.DesignPatterns.structural.composite.OrderBox;
import com.company.DesignPatterns.structural.composite.ProductItem;
import com.company.DesignPatterns.structural.decorator.KetchUpSandwich;
import com.company.DesignPatterns.structural.decorator.Sandwich;
import com.company.DesignPatterns.structural.decorator.VegetableSandwich;
import com.company.DesignPatterns.structural.facade.CombineRandomStringWithRandomListString;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		//Singleton pattern -> usually database connections and reusable objects expensive to recreate
		SingletonCarEngineParts parts = SingletonCarEngineParts.getInstance();
		SingletonCarEngineParts parts1 = SingletonCarEngineParts.getInstance();

		if (parts == parts1) {
			System.out.println("This is the same object");
			System.out.println("Object 1: " + parts.toString());
			System.out.println("Object 2: " + parts1.toString());
		}


		//Builder pattern -> String builder, document builder
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


		//prototype pattern -> implementing cloneable inteface
		AlienDNA originalAlienDNA = new AlienDNA("adenine-40%", "guanine-10%", "cytosine-25%", "thymine-25%");
		System.out.println(originalAlienDNA.getCloneSuccessful());
		AlienDNA copyAlienDNA = (AlienDNA) originalAlienDNA.getPrototypeDNA();
		System.out.println(copyAlienDNA.getCloneSuccessful());


		//factory pattern -> creating new object i.e calendar.getInstance();
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
		//using the adapter -> recycler view adapter android
		wareHouseProductsList.addAll(ProductConverterAdapter.convertStoreProductToWareHouseProduct(storeProducts));

		ArrayList<StoreProduct> storeProductsList = new ArrayList<>();
		storeProductsList.addAll(storeProducts);
		//using the adapter
		storeProductsList.addAll(ProductConverterAdapter.convertWareHouseProductsToStoreProducts(wareHouseProducts));

		//bridge pattern  -> jdbc
		SquareDistorter procedure = new SquareDistorter();
		ReverseNumberDistorter procedure1 = new ReverseNumberDistorter();

		RandomCodeCreator creator = new RandomCodeCreator(123343, 322020, procedure);
		RandomCodeCreator creator1 = new RandomCodeCreator(78842372, 3257248, procedure1);

		System.out.println(creator.getRandomCode());
		System.out.println(creator1.getRandomCode());


		//composite pattern - tree structure -> Document builder i.e html
		ProductItem fan = new ProductItem("Ceiling fan", 100);
		ProductItem screwDriver = new ProductItem("Screw Driver", 100);
		ProductItem pipeWrench = new ProductItem("Pipe Wrench", 100);

		OrderBox completeWorkTools = new OrderBox("Complete Work Tools");
		OrderBox onlyScrewDriver = new OrderBox("Only Screw Driver");
		OrderBox pipeWrenchAndCeilingFan = new OrderBox("Pipe Wrench + Ceiling Fan");
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


		//decorator pattern/wrapper -> I/O streams in java
		Sandwich sandwich = new Sandwich();
		VegetableSandwich vegetableSandwich = new VegetableSandwich(sandwich);
		KetchUpSandwich ketchUpSandwich = new KetchUpSandwich(vegetableSandwich);
		ketchUpSandwich.selectCondiments();
		ketchUpSandwich.addCondiments();
		ketchUpSandwich.statusOfSandwich();

		//facade pattern - complex api that you need to expose with a simpler abstraction
		//http URL connection in java
		CombineRandomStringWithRandomListString combine = new CombineRandomStringWithRandomListString();
		System.out.println(combine.combineStringListAndComplexString());


		//chain of responsibility pattern - passing commands down a chain until a matching processor can handle it
		// example -> spring security filter chain
		Steel steel = new Steel(SteelType.STAINLESS_STEEL);
		CarbonSteelHandler carbonSteelHandler = new CarbonSteelHandler(steel);
		Steel processedSteel = carbonSteelHandler.processSteel();
		List<String> props = processedSteel.getSteelProps();
		for (String prop : props) {
			System.out.println(prop);
		}

		//command pattern - encapsulates the implementation or processing in individual objects -> runnable interface
		PaintHouse builder = new PaintHouse();
		FoundationLayer layer = new FoundationLayer();
		House house = new House(builder);
//		house = new House(layer);
		house.performBuildTask();
	}
}
