package dmiv.utils;

import java.awt.image.BufferedImage;

public class ImageProcessor {
	
	public static BufferedImage crop(BufferedImage img, int x, int y, int width, int height) {
		if(x < 0 || x + width > img.getWidth() || y < 0 || y + height > img.getHeight()) {
			System.out.println("++++++++++++++++++++++++++++++++++");
			System.err.println("Can't crop: image is out of bounds");
			return null;
		}
		return img.getSubimage(x, y, width, height);
	}
}
