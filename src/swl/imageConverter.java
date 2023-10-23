package swl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class imageConverter {

	public void printArt(char[][] art, OutputStream out) {
		for (char[] row : art) {
			for (char ch : row)
			try {
				out.write((byte)ch);
			}
			catch (Exception e) {
				e.getStackTrace();
			}	
		}
	}
	
	public char[][] makeArtByASCII(String filename, int heightCoef, int widthCoef) {
		BufferedImage image;
		try {
			image = ImageIO.read(this.getClass().getResource(filename));
		}
		catch (IOException e) {
			e.getStackTrace();
			char[][] specialCase= {{'e','r','r','o','r','\n'}};
			return specialCase;
		}
		return convert(image, heightCoef, widthCoef);
	}

	private char[][] convert(BufferedImage image, int heightCoef, int widthCoef) {
		int height = image.getHeight() / heightCoef;
		int width = image.getWidth() / widthCoef;
		
		char[][] chars = new char[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width - 1; j++) {
				int rgbPoint = 0;
				for (int k = 0; k < heightCoef; k++)
					for (int v = 0; v < widthCoef; v++)
						rgbPoint += image.getRGB(j * widthCoef + v, i * heightCoef + k);
				Color color = new Color(rgbPoint / (heightCoef * widthCoef));
				int brightness = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
				chars[i][j] = getCharacterByBrightness(brightness);
			}
			chars[i][width - 1] = '\n';
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
