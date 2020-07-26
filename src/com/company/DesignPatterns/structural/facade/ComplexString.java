package com.company.DesignPatterns.structural.facade;

import java.util.Random;

public class ComplexString {

	public ComplexString() {
	}
	public String getComplexString(){
		return String.valueOf(new Random().nextInt(10000000));
	}
}
