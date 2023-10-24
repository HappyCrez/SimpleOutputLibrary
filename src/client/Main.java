package client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import swl.Rectangle;
import swl.Text;
import swl.Canvas;
import swl.Circle;
import swl.imageConverter;

public class Main {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		Circle circle = new Circle("Circle - title", 5);
		Rectangle rectangle = new Rectangle("Rectangle - Title", 40);
		Text text = new Text("It's my text, that i can load from any file,\n and save to any file\n\n");
		canvas.add(circle);
		canvas.add(rectangle);
		canvas.add(text);
		
		try (FileOutputStream out = new FileOutputStream("note.txt", false))
		{
			canvas.draw(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		imageConverter img = new imageConverter();
		char[][] art = img.makeArtByASCII("image.png", 10, 6);
		
		try (FileOutputStream out = new FileOutputStream("image.txt", false))
		{
			img.printArt(art, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
