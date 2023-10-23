package client;

import swl.Rectangle;
import swl.Canvas;
import swl.Circle;
import swl.imageConverter;

public class Main {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		Circle circle = new Circle("Circle", 5);
		Rectangle rectangle = new Rectangle("Rectangle", 40);
		canvas.add(circle);
		canvas.add(rectangle);
		canvas.add(rectangle);
		canvas.clear();
		canvas.draw(System.out);
		
		imageConverter img = new imageConverter();
		char[][] art = img.makeArtByASCII("image.png", 10, 6);
		img.printArt(art, System.out);
	}
}
