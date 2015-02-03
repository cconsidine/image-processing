import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/**
 * @author Patrick Wamsley
 * @author Camille Considine
 */

public class ReduceIntensity implements PlugInFilter {

	private ImagePlus imp;

	@Override
	public int setup(String arg0, ImagePlus arg1) {
		this.imp = imp;
		return DOES_ALL;
	}

	@Override
	public void run(ImageProcessor ip) {

		int width = ip.getWidth(); 
		int height = ip.getHeight();

		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				int intensity = ip.get(c, r); 
				int setVal = intensity/16 * 16; 
				ip.set(c, r, setVal);
			}
		}
	}
}
