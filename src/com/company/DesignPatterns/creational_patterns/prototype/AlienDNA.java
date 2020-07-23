package com.company.DesignPatterns.creational_patterns.prototype;

public class AlienDNA implements Cloneable {

	private String adenineSequence;
	private String guanineSequence;
	private String cytosineSequence;
	private String thymineSequence;
	private boolean cloneSuccessful = false;


	public AlienDNA(String a, String g, String c, String t) {
		this.adenineSequence = a;
		this.cytosineSequence = c;
		this.guanineSequence = g;
		this.thymineSequence = t;
	}

	public boolean getCloneSuccessful() {
		return cloneSuccessful;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("I see you want to clone an alien yourself; " +
				"be careful with this knowledge, ensure it never falls to the enemy!");
		this.cloneSuccessful = true;
		return super.clone();
	}

	public AlienDNA getPrototypeDNA (){
		try {
			return (AlienDNA) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
