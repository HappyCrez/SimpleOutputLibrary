package swl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imageConverter {

	private BufferedImage image;
	
	public imageConverter() {
		this.image = null;
	}
	
	public imageConverter(BufferedImage image) {
		this.image = image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void readImage(String path) {
		try {
			image = ImageIO.read(this.getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("file doesn't exists");
		}
	}
	
	public void print() {
		char chars[][] = convert(2, 2);
		
		 for (char[] row : chars) {
		   String str = String.valueOf(row);
		   System.out.println(str);
		}
	}
	
	public void printToFile(String path) {
		
	}
	
	private char[][] convert(int heightCoef, int widthCoef){
		int width = image.getWidth() / widthCoef;
		int height = image.getHeight() / heightCoef;
		
		char[][] chars = new char[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int rgbPoint = 0;
				for (int k = 0; k < heightCoef; k++)
					for (int v = 0; v < widthCoef; v++)
						rgbPoint += image.getRGB(j * heightCoef + k, i * widthCoef + v);
				Color color = new Color(rgbPoint / (heightCoef * widthCoef));
				int brightness = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
				chars[i][j] = getCharacterByBrightness(brightness);
			}
		}
		return chars;
	}

	static final String DENSITY =
		      "@QB#NgWM8RDHdOKq9$6khEPXwmeZaoS2yjufF]}{tx1zv7lciL/\\|?*>r^;:_\"~,'.-`";
	
	private char getCharacterByBrightness(int brightness) {
		int charIndex = (int)(DENSITY.length() / 255.0 * brightness);
		charIndex = Math.max(charIndex, 0);
		charIndex = Math.min(charIndex, DENSITY.length() - 1);	
		return DENSITY.charAt(charIndex);
	}
	
}
