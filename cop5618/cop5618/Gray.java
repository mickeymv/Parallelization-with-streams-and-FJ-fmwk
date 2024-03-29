package cop5618;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.util.Arrays;
 

public class Gray {

	//For use with Timer class.  There should be labels.length+1 calls to the Timer instance' now
	//method
	public static String[] ssLabels = { "getRGB", "serial stream processing", "setRGB" };
	public static String[] psLabels = {"getRGB", "parallel stream processing", "setRGB"};
	public static String[] fjSSLabels = { "getRGB", "FJ serial stream processing", "setRGB" };
	public static String[] fjPSLabels = {"getRGB", "FJ parallel stream processing", "setRGB"};

	/**
	 * Serial program to convert color image to grayscale.
	 * Returns a Timer object with timing data collected during its execution.
	 * 
	 * @param image
	 * @param newImage
	 * @return
	 */
	public static Timer gray_SS(BufferedImage image, BufferedImage newImage) {
		Timer time = new Timer(ssLabels);
		ColorModel colorModel = ColorModel.getRGBdefault();
		int w = image.getWidth();
		int h = image.getHeight();
		time.now();
		int[] sourcePixelArray = image.getRGB(0, 0, w, h, new int[w * h], 0, w);
		time.now();
		int[] grayPixelArray =
				// get array of pixels from image and convert to stream
				Arrays.stream(sourcePixelArray)
						// combine red, green, and blue values to obtain gray
						// value
						.map(pixel -> (int) ((colorModel.getRed(pixel) * .299) + (colorModel.getGreen(pixel) * .587)
								+ (colorModel.getBlue(pixel) * .114)))
						// make a new pixel where all three colors have the same
						// gray value
						.map(grayVal -> HW3Utils.makeRGBPixel(grayVal, grayVal, grayVal))
						// convert stream to array
						.toArray();
		time.now();
		// create a new Buffered image and set its pixels to the gray pixel
		// array
		newImage.setRGB(0, 0, w, h, grayPixelArray, 0, w);
		time.now();
		return time;
	}
	public static Timer gray_SS_FJ(FJBufferedImage image, FJBufferedImage newImage) {
		Timer time = new Timer(fjSSLabels);
		/**Implement this function with serial stream processing and parallel setRGB and getRGB */
		ColorModel colorModel = ColorModel.getRGBdefault();
		int w = image.getWidth();
		int h = image.getHeight();
		time.now();
		int[] sourcePixelArray = image.getRGB(0, 0, w, h, new int[w * h], 0, w);
		time.now();
		int[] grayPixelArray =
				// get array of pixels from image and convert to stream
				Arrays.stream(sourcePixelArray)
						// combine red, green, and blue values to obtain gray
						// value
						.map(pixel -> (int) ((colorModel.getRed(pixel) * .299) + (colorModel.getGreen(pixel) * .587)
								+ (colorModel.getBlue(pixel) * .114)))
						// make a new pixel where all three colors have the same
						// gray value
						.map(grayVal -> HW3Utils.makeRGBPixel(grayVal, grayVal, grayVal))
						// convert stream to array
						.toArray();
		time.now();
		// create a new Buffered image and set its pixels to the gray pixel
		// array
		newImage.setRGB(0, 0, w, h, grayPixelArray, 0, w);
		time.now();
		return time;
	}

	public static Timer gray_PS_FJ(FJBufferedImage image, FJBufferedImage newImage) {
		Timer time = new Timer(fjPSLabels);
		/**Implement this function with parallel stream processing and parallel setRGB and getRGB */
		ColorModel colorModel = ColorModel.getRGBdefault();
		int w = image.getWidth();
		int h = image.getHeight();
		time.now();
		int[] sourcePixelArray = image.getRGB(0, 0, w, h, new int[w * h], 0, w);
		time.now();
		int[] grayPixelArray =
				// get array of pixels from image and convert to stream
				Arrays.stream(sourcePixelArray)
						//parallelize the operations
						.parallel()
						// combine red, green, and blue values to obtain gray
						// value
						.map(pixel -> (int) ((colorModel.getRed(pixel) * .299) + (colorModel.getGreen(pixel) * .587)
								+ (colorModel.getBlue(pixel) * .114)))
						// make a new pixel where all three colors have the same
						// gray value
						.map(grayVal -> HW3Utils.makeRGBPixel(grayVal, grayVal, grayVal))
						// convert stream to array
						.toArray();
		time.now();
		// create a new Buffered image and set its pixels to the gray pixel
		// array
		newImage.setRGB(0, 0, w, h, grayPixelArray, 0, w);
		time.now();
		return time;
	}



	
	public static Timer gray_PS(BufferedImage image, BufferedImage newImage) {
		Timer time = new Timer(psLabels);
		/**Implement this function with parallel stream processing and serial setRGB and getRGB */
		ColorModel colorModel = ColorModel.getRGBdefault();
		int w = image.getWidth();
		int h = image.getHeight();
		time.now();
		int[] sourcePixelArray = image.getRGB(0, 0, w, h, new int[w * h], 0, w);
		time.now();
		int[] grayPixelArray =
				// get array of pixels from image and convert to stream
				Arrays.stream(sourcePixelArray)
						//parallelize the operations
						.parallel()
						// combine red, green, and blue values to obtain gray
						// value
						.map(pixel -> (int) ((colorModel.getRed(pixel) * .299) + (colorModel.getGreen(pixel) * .587)
								+ (colorModel.getBlue(pixel) * .114)))
						// make a new pixel where all three colors have the same
						// gray value
						.map(grayVal -> HW3Utils.makeRGBPixel(grayVal, grayVal, grayVal))
						// convert stream to array
						.toArray();
		time.now();
		// create a new Buffered image and set its pixels to the gray pixel
		// array
		newImage.setRGB(0, 0, w, h, grayPixelArray, 0, w);
		time.now();
		return time;
	}


}
