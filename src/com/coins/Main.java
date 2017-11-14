package com.coins;

import java.util.ArrayList;

import org.opencv.core.Mat;

import rapport.Rapport;

public class Main {

	public static void main(String[] args) {

		Mat coins = DetectCircle.drawCircles("src/images/coins.jpg");
		
		new ImageViewer().show(coins, "circles");
		
		ArrayList<Coin> id = DetectCircle.identifyCircles("src/images/coins.jpg");
		
		for(int i = 0 ; i < id.size(); i++) 
		{ 
			if( i+1 != id.size())
			{
				Coin c1 = id.get(i);
				Coin c2 = id.get(i+1);
				System.out.println(c1);
				float rapport = c1.getDiameter()/c2.getDiameter();
				Rapport.CheckForCoins(c1, c2, rapport);
			}
		}
		
		for(int i = 0 ; i < id.size(); i++) 
		{
			Coin c1 = id.get(i)   ;
			System.out.println(c1);
		}
	}

}
