package com.coins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Coin {
	

	private float diameter;
	private float value;
	
	
	public Coin(float diameter) {
		super();
		this.diameter = diameter;
	}


	public Coin(float diameter, float value) {
		super();
		this.diameter = diameter;
		this.value = value;
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


	@Override
	public String toString() {
		return "Coin [diameter=" + diameter + "]";
	}
	
}
