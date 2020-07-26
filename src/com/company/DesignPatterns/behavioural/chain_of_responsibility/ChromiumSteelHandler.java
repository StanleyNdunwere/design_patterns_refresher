package com.company.DesignPatterns.behavioural.chain_of_responsibility;

public class ChromiumSteelHandler extends Processor {
	Processor successor;

	public ChromiumSteelHandler(Steel steel) {
		this.successor = new StainlessSteelHandler(steel);
		this.steel = steel;
	}

	@Override
	public Steel processSteel() {
		if (this.steel.getSteelType() == SteelType.CHROMIUM_STEEL) {
			System.out.println("One Bar of Chromium Steel Coming Right Up");
			steel.setCarbonAdded(true);
			steel.setIronAdded(true);
			steel.setChromiumAdded(true);
			steel.setNickelAdded(false);
			this.setSteelProperties();
			return steel;
		} else {
			System.out.println("Unable to process steel request. Passing down to Stainless Steel Handler");
			return successor.processSteel();
		}
	}

}
