package com.company.DesignPatterns.creational_patterns.builder;

public class PizzaOrder {


	private String meatType;
	private String doughType;
	private String flavorings;
	private String sodaType;
	public PizzaOrderBuilder builder;

	public PizzaOrder(PizzaOrderBuilder orderBuilder) {
		this.builder = orderBuilder;
		this.meatType = orderBuilder.meatType;
		this.doughType = orderBuilder.doughType;
		this.flavorings = orderBuilder.flavorings;
		this.sodaType = orderBuilder.sodaType;
	}

	public String getMeatType() {
		return meatType;
	}


	public String getDoughType() {
		return doughType;
	}


	public String getFlavorings() {
		return flavorings;
	}


	public String getSodaType() {
		return sodaType;
	}

	public static class PizzaOrderBuilder {

		private String meatType;
		private String doughType;
		private String flavorings;
		private String sodaType;

		public PizzaOrderBuilder() {
		}

		public PizzaOrder build() {
			return new PizzaOrder(this);
		}

		public PizzaOrderBuilder meatType(String meatType) {
			this.meatType = meatType;
			return this;
		}

		public PizzaOrderBuilder doughType(String doughType) {
			this.doughType = doughType;
			return this;
		}

		public PizzaOrderBuilder flavorings(String flavorings) {
			this.flavorings = flavorings;
			return this;
		}

		public PizzaOrderBuilder sodaType(String sodaType) {
			this.sodaType = sodaType;
			return this;
		}
	}
}
