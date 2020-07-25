package com.company.DesignPatterns.structural.bridge;

public class RandomCodeCreator {

	private int salt;
	private int seed;
	private DistortNumber procedure;

	public RandomCodeCreator(int salt, int seed, DistortNumber procedure) {
		this.salt = salt;
		this.seed = seed;
		this.procedure = procedure;
	}


	public String getRandomCode() {
		int num = procedure.distortNumber(salt);
		return String.valueOf(num * 129846);
	}


}
