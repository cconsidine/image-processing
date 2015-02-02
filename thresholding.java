import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.filter.*;

public class Thresholding implements PlugInFilter {
	ImagePlus imp;

	private ImageProcessor ip; 

	public int setup(String arg, ImagePlus imp) {
		this.imp = imp;
		return DOES_ALL;
	}

	public void run(ImageProcessor ip) {

		this.ip = ip;  

		rangePixelColors(100, 200); 
	}

	public void rangePixelColors(int aMin, int aMax) {

		int w = ip.getWidth(); 
		int h = ip.getHeight();
		
		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				int a = ip.get(c, r);
				double newPix = aMin + (a - aMin) * (aMax - aMin) / (255); 
				ip.set(c, r, (int)newPix); 		
			}
		}
	}

	public void filterPixelsAbove(int newIntensity, int lowerBounds) {

		int w = ip.getWidth(); 
		int h = ip.getHeight(); 

		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				int intensity = ip.get(c, r);
				if (intensity >= lowerBounds)
					ip.set(c, r, newIntensity); 
			}
		}
	}
	public void filterPixelsBelow(int newIntensity, int higherBounds) {

		int w = ip.getWidth(); 
		int h = ip.getHeight(); 

		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				int intensity = ip.get(c, r);
				if (intensity <= higherBounds)
					ip.set(c, r, newIntensity); 
			}
		}
	}
		public void filterPixelColors(int newIntensityLow, int newIntensityHigh, 
		int lowerBounds, int higherBounds) {

		int w = ip.getWidth(); 
		int h = ip.getHeight(); 

		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				int intensity = ip.get(c, r);
				if (intensity <= higherBounds)
					ip.set(c, r, newIntensityLow); 
				else if (intensity >= lowerBounds)
					ip.set(c, r, newIntensityHigh); 
				}
			}
		}
}
