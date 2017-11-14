package com.coins;

import java.util.ArrayList;

public class CoinsGen {
	

	
	
	public static ArrayList<Coin> GenerateBaseCoins() {
		
		ArrayList<Coin> ALIC = new ArrayList<>();
 		// C1
		Coin C1 = new Coin();
		C1.setDiameter(17);
		C1.setValue(0.01f);
		ALIC.add(C1);
		//C5
		Coin C5 = new Coin();
		C5.setDiameter(17.5f);
		C5.setValue(0.05f);
		ALIC.add(C5);
		
		//C10
		Coin C10 = new Coin();
		C10.setDiameter(20);
		C10.setValue(0.1f);
		ALIC.add(C10);
		
		//C20
		Coin C20 = new Coin();
		C20.setDiameter(23);
		C20.setValue(0.2f);
		ALIC.add(C20);
		
		//C50
		Coin C50 = new Coin();
		C50.setDiameter(21);
		C50.setValue(0.5f);
		ALIC.add(C50);
		
		// D1
		Coin D1 = new Coin();
		D1.setDiameter(24);
		D1.setValue(1);
		ALIC.add(D1);
		
		//D2
		Coin D2 = new Coin();
		D2.setDiameter(26);
		D2.setValue(2);
		ALIC.add(D2);
		
		//D5
		Coin D5 = new Coin();
		D5.setDiameter(25);
		D5.setValue(5);
		ALIC.add(D5);
		
		//D10
		Coin D10 = new Coin();
		D10.setDiameter(28);
		D10.setValue(10);
		ALIC.add(D10);
		
		return ALIC;
		
	}

}
