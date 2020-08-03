package com.company.DesignPatterns.behavioural.command;

public class PaintHouse implements HouseBuilder {
	@Override
	public void execute() {
		System.out.println("House Is Painted");
	}
}
