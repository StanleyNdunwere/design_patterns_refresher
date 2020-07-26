package com.company.DesignPatterns.behavioural.chain_of_responsibility;

import java.util.List;

public class Steel {

	private boolean ironAdded;
	private boolean carbonAdded;
	private boolean nickelAdded;
	private boolean chromiumAdded;
	private SteelType steelType;
	private List<String> steelProps;


	public void setSteelProps(List<String> steelProps) {
		this.steelProps = steelProps;
	}

	public Steel(SteelType steelType) {
		this.carbonAdded = false;
		this.ironAdded = false;
		this.chromiumAdded = false;
		this.nickelAdded = false;
		this.steelType = steelType;
	}

	public boolean isIronAdded() {
		return ironAdded;
	}

	public void setIronAdded(boolean ironAdded) {
		this.ironAdded = ironAdded;
	}

	public boolean isCarbonAdded() {
		return carbonAdded;
	}

	public void setCarbonAdded(boolean carbonAdded) {
		this.carbonAdded = carbonAdded;
	}

	public boolean isNickelAdded() {
		return nickelAdded;
	}

	public void setNickelAdded(boolean nickelAdded) {
		this.nickelAdded = nickelAdded;
	}

	public boolean isChromiumAdded() {
		return chromiumAdded;
	}

	public void setChromiumAdded(boolean chromiumAdded) {
		this.chromiumAdded = chromiumAdded;
	}

	public SteelType getSteelType() {
		return steelType;
	}


	public void setSteelType(SteelType steelType) {
		this.steelType = steelType;
	}

	public List<String> getSteelProps() {
		return steelProps;
	}
}
