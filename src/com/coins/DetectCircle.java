package com.coins;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class DetectCircle {
	
	static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
	
	public static void Detect(String path) {
		//read image
		Mat image = Imgcodecs.imread(path);
		
		if(image.dataAddr() == 0) {
			System.out.println("Error in reading image");
		}
		else {
		
			Mat gray = new Mat();
			Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);
			//Imgproc.Canny(gray, gray, 1, 1);
		
			Imgproc.medianBlur(gray, gray, 11);
			new ImageViewer().show(gray, "Blur");
			Mat circles = new Mat();
			
			//Imgproc.HoughCircles(gray, circles, Imgproc.HOUGH_GRADIENT, 1, 1);
			
			Imgproc.HoughCircles(gray, circles, Imgproc.HOUGH_GRADIENT, 1.0,
	                (double)gray.rows()/16, // change this value to detect circles with different distances to each other
	                100.0, 30.0, 1, 10000); // change the last two parameters
	                // (min_radius & max_radius) to detect larger circles

			
			for(int i=0; i<circles.cols(); i++) {
				double[] c = circles.get(0, i);
				Point center = new Point(Math.round(c[0]), Math.round(c[1]));
				
				Imgproc.circle(image, center, 1, new Scalar(0,100,100), 3, 8, 0 );
	            int radius = (int) Math.round(c[2]);
	            Imgproc.circle(image, center, radius, new Scalar(255,0,255), 3, 8, 0 );
				
			}
			
			new ImageViewer().show(image, "circles");
			
			System.out.println("Circles ="+circles.dump());
			System.out.println(circles);
			
			
		}
	}

}
