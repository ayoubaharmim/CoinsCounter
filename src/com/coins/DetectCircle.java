package com.coins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import com.sun.javafx.geom.Edge;

public class DetectCircle {
	
	static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
 
	public static Mat readImg(String filePath){

		Mat img = Imgcodecs.imread(filePath);

		if(img.dataAddr() == 0) {
				System.out.println("Error in reading image");
				System.exit(0);
			}

			return img;

	}

	public static Mat matOfCircles(String filePath){

		Mat circles = new Mat();

		Mat img = DetectCircle.readImg(filePath);
		Mat gray = new Mat();
		Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);
		Imgproc.medianBlur(gray, gray, 11);
		//Imgproc.Canny(gray, gray, 0, 11);
		Imgproc.HoughCircles(gray, circles, Imgproc.HOUGH_GRADIENT, 1.0,
		                (double)gray.rows()/16, // change this value to detect circles with different distances to each other
		                100.0, 30.0, 1, 1000); // change the last two parameters
		                // (min_radius & max_radius) to detect larger circles
		                
		return circles;
	}

	public static Mat drawCircles(String filePath){

		Mat dest = DetectCircle.readImg(filePath);
		Mat circles = DetectCircle.matOfCircles(filePath);

		for(int i=0; i<circles.cols(); i++){
			double[] c = circles.get(0,i);
			Point center = new Point(Math.round(c[0]), Math.round(c[1]));

			Imgproc.circle(dest, center, 1, new Scalar(0,100,100), 3, 8, 0 );
		    int diameter = (int) Math.round(c[2]);
		    Imgproc.circle(dest, center, diameter, new Scalar(255,0,255), 3, 8, 0 );
		}

		return dest;

	}


	
	public static ArrayList<Coin> identifyCircles(String filePath){
		ArrayList<Coin> coins = new ArrayList<>();
		//Mat dest = DetectCircle.readImg(filePath);
		Mat circles = DetectCircle.matOfCircles(filePath);

		for(int i=0; i<circles.cols(); i++){
			double[] c = circles.get(0,i);
			//Point center = new Point(Math.round(c[0]), Math.round(c[1]));
		    float diameter = Math.round(c[2]);
		    coins.add(new Coin(diameter));

		}
		return coins;
	}

}
