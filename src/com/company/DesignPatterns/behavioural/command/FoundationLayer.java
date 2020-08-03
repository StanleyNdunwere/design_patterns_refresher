package com.company.DesignPatterns.behavioural.command;

public class FoundationLayer implements HouseBuilder {
	@Override
	public void execute() {
		System.out.println("New Foundation Laid");
	}
}
