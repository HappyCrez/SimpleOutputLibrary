package client;

import swl.Rectangle;
import swl.Table;
import swl.Circle;
import swl.imageConverter;

public class Main {

	public static void main(String[] args) {
		Table canvas = new Table();
		Circle lbl = new Circle("Label", 20);
		Rectangle btn = new Rectangle("Button", 40);
		canvas.add(lbl);
		canvas.add(btn);
		canvas.draw();
		
		
		imageConverter img = new imageConverter();
		img.readImage("image.jpeg");
		img.print();
	}
}
