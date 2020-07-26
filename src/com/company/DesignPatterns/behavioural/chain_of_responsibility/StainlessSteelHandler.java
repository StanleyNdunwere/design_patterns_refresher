package com.company.DesignPatterns.behavioural.chain_of_responsibility;

public class StainlessSteelHandler extends Processor {

	public StainlessSteelHandler(Steel steel) {
		this.steel = steel;
	}

	@Override
	public Steel processSteel() {
		steel.setCarbonAdded(true);
		steel.setIronAdded(true);
		steel.setChromiumAdded(true);
		steel.setNickelAdded(true);
		this.setSteelProperties();
		return steel;
	}

}
