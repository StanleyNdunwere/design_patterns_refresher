package com.company.DesignPatterns.behavioural.command;

public class House {

	HouseBuilder builder;

	public House(HouseBuilder builder){
		this.builder = builder;
	}

	public void performBuildTask(){
		this.builder.execute();
	}

}
