package com.coins;

import org.opencv.core.Mat;

public class Main {

	public static void main(String[] args) {
		Mat img = DetectCircle.detect("src/images/coins.jpg");
		
		new ImageViewer().show(img, "Circles");

	}

}
