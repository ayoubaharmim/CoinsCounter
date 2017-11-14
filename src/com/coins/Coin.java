package com.coins;

public class Coin {
	

	private float diameter;
	private float value;
	
	public Coin() {
		super();
	}
	public Coin(float diam) {
		this.diameter = diam;
	}
	public Coin(float diam, float value) {
		this.diameter = diam;
		this.value    = value;
	}
	
	



	
	public float getDiameter() {
		return diameter;
	}
	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	
	
	
	
	}
