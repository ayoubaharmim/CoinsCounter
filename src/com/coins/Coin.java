package com.coins;

public class Coin {
	

	private float diameter;
	private float radius;
	private float value;
	private float[] rapport;
	
	
	public Coin(float diameter, float radius, float value, float[] rapport) {
		super();

		this.diameter = diameter;
		this.radius = radius;
		this.value = value;
		
		for(int i=0; i<rapport.length; i++) {
			this.rapport[i] = rapport[i];
		}
	}
	
	
	
	public Coin() {
		super();
	}



	
	public float getDiameter() {
		return diameter;
	}
	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public float[] getRapport() {
		return rapport;
	}
	public void setRapport(float[] rapport) {
		
		for(int i=0; i<rapport.length; i++) {
			this.rapport[i] = rapport[i];
			
		}
	}
	
	
	
	}
