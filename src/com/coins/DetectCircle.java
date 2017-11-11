package com.coins;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class DetectCircle {
	
	static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
	
	public static void detect(String path) {
		//read image
		Mat image = Imgcodecs.imread(path);
		
		if(image.dataAddr() == 0) {
			System.out.println("Error in reading image");
		}
		else {
			
		//gray image
			Mat gray = new Mat();
			Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);
			
		//applying median blur
			Imgproc.medianBlur(gray, gray, 5);
			
			Mat circles = new Mat();
			
			Imgproc.HoughCircles(gray, circles, Imgproc.HOUGH_GRADIENT, 1.0, (double)gray.rows()/16);
			
			for(int i=0; i<circles.cols(); i++) {
				double[] c = circles.get(0, i);
				Point center = new Point(Math.round(c[0]), Math.round(c[1]));
				
				//circle center
				Imgproc.circle(image, center, 1, new Scalar(0,100,100), 3,8,0);
				//circle outline
				int radius = (int)Math.round(c[2]);
				Imgproc.circle(image, center, radius, new Scalar(255,0,255), 3, 8, 0);
				
				
			}
			new ImageViewer().show(image, "Circles");
		}
	}

}
