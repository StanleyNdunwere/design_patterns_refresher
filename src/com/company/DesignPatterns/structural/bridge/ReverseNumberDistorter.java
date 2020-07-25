package com.company.DesignPatterns.structural.bridge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseNumberDistorter extends DistortNumber {
	@Override
	int distortNumber(int numberToDistort) {
		String[] split = String.valueOf(numberToDistort).split("");
		List<String> arr = Arrays.asList(split);
		Collections.reverse(arr);
		StringBuilder builder = new StringBuilder();
		for (String a : arr) {
			builder.append(a);
		}
		return Integer.parseInt(builder.toString());
	}
}
