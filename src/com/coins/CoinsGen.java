package com.coins;

import java.util.ArrayList;

public class CoinsGen {
	
	public static float calculateSum(String filePath) {
		//generating the moroccan coins
		
		Coin oneDh = new Coin(24, 1);
		Coin twoDh = new Coin(26, 2);
		Coin fiveDh = new Coin(25, 5);
		Coin tenDh = new Coin(28, 10);
		
		// for more information about moroccan currency, visit: https://en.wikipedia.org/wiki/Moroccan_dirham
		
		
		//get the scale
		float scale = tenDh.getDiameter()/DetectCircle.reference(filePath);
		
		//generating an arrayList of coins
		
		ArrayList<Coin> coins = new ArrayList<>();
		coins.add(oneDh); // i=0
		coins.add(twoDh); //i=1
		coins.add(fiveDh); //i=2
		coins.add(tenDh); //i=3
		
		ArrayList<Coin> imgCoins = DetectCircle.identifyCircles(filePath);
		float sum = 0;
		for(int i=0; i<imgCoins.size(); i++) {
			for(int j=0; j<coins.size(); j++) {
				if(Math.round(imgCoins.get(i).getDiameter()*scale) - coins.get(j).getDiameter() == 0 ) {
					sum+= coins.get(j).getValue();
				}
			}
		}
		
		return sum;
		
	}

}
