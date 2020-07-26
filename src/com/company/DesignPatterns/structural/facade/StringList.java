package com.company.DesignPatterns.structural.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringList {
	public StringList() {
	}

	public List<String> getListOfComplexStrings() {
		List<String> stringList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			int val = Integer.parseInt("1234567656") + new Random().nextInt();
			stringList.add(String.valueOf(val));
		}
		return stringList;
	}
}
