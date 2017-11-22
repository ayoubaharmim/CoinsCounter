package com.coins;

import java.util.ArrayList;

import org.opencv.core.Mat;

public class Main {
	
	

	public static void main(String[] args) {
		Mat coins = DetectCircle.drawCircles("src/images/test.jpg");
		
		new ImageViewer().show(coins, "circles");
		
		ArrayList<Coin> id = DetectCircle.identifyCircles("src/images/test.jpg");
		
		for(Coin c: id) {
			System.out.println(c+" mm");
		}
		
		float ref = DetectCircle.reference("src/images/test.jpg");
		System.out.println("REFERENCE = "+ref);
		
		float sum = CoinsGen.calculateSum("src/images/test.jpg");
		System.out.println(sum);

	}
	
	

}
