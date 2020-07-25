package com.company.DesignPatterns.structural.bridge;

public class SquareDistorter extends DistortNumber{
	@Override
	int distortNumber(int numberToDistort) {
		return (int) Math.round(Math.pow(numberToDistort, 2));
	}
}
