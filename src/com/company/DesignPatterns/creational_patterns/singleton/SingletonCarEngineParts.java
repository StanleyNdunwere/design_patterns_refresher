package com.company.DesignPatterns.creational_patterns.singleton;

public class SingletonCarEngineParts {

	static private SingletonCarEngineParts engineParts;

	private SingletonCarEngineParts() {
	}

	public static SingletonCarEngineParts getInstance() {
		if (engineParts == null) {
			engineParts = new SingletonCarEngineParts();
		}
		return engineParts;
	}

}
