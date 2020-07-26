package com.company.DesignPatterns.behavioural.chain_of_responsibility;

public class CarbonSteelHandler extends Processor{

	Processor successor;

	public CarbonSteelHandler(Steel steel) {
		this.successor = new ChromiumSteelHandler(steel);
		this.steel = steel;
	}

	@Override
	public Steel processSteel() {
		if (this.steel.getSteelType() == SteelType.CARBON_STEEL) {
			System.out.println("One Bar of Carbon Steel coming right up");
			this.steel.setCarbonAdded(true);
			this.steel.setIronAdded(true);
			this.steel.setChromiumAdded(false);
			this.steel.setNickelAdded(false);
			this.setSteelProperties();
			return this.steel;
		}else{
			System.out.println("Unable to process steel request. Passing down to Chromium Steel Handler");
			return successor.processSteel();
		}
	}
}
