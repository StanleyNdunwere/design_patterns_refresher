package com.company.DesignPatterns.structural.facade;

import java.util.List;

public class CombineRandomStringWithRandomListString {
	private StringList stringList;
	private ComplexString complexString;

	public CombineRandomStringWithRandomListString() {
		this.stringList = new StringList();
		this.complexString = new ComplexString();
	}

	public String combineStringListAndComplexString() {
		List<String> stringList = this.stringList.getListOfComplexStrings();
		String compString = this.complexString.getComplexString();
		StringBuilder builder = new StringBuilder();
		for (String s : stringList) {
			builder.append(s);
		}
		builder.append(compString);
		System.out.println("Assume this method combines two rather complex APIs and returns a " +
				"\nsimple method to access the values without bothering about understanding\n" +
				" the intricacies of the rather complex APIs");

		return builder.toString();
	}

}
