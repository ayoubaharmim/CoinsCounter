package com.coins;

import java.util.ArrayList;

import org.opencv.core.Mat;

public class Main {

	public static void main(String[] args) {
		//Mat coins = DetectCircle.drawCircles("src/images/coins.jpg");
		
		//new ImageViewer().show(coins, "circles");
		
		ArrayList<Coin> id = DetectCircle.identifyCircles("src/images/coins.jpg");
		
		for(Coin c: id) {
			System.out.println(c);
		}

	}

}
