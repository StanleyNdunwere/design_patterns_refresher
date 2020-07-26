package com.company.DesignPatterns.behavioural.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

public abstract class Processor {
	Steel steel;

	public abstract Steel processSteel();

	public void setSteelProperties() {
		List<String> props = new ArrayList<>();
		if (steel.isCarbonAdded()) props.add("Carbon Added");
		if (steel.isChromiumAdded()) props.add("Chromium Added");
		if (steel.isIronAdded()) props.add("Iron Added");
		if (steel.isNickelAdded()) props.add("Nickel Added");
		steel.setSteelProps(props);
	}

}
