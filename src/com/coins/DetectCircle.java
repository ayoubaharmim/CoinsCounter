package com.coins;

import org.opencv.core.Core;
import org.opencv.core.Mat;
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
		}
	}

}
