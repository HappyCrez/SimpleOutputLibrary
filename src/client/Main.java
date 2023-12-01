package client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import swl.*;

public class Main {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();

		Circle circle = new Circle("Circle - title", 5);
		Text text = new Text("It's my text, that i can load from any file,\n and save to any file\n\n");

		for (int i = 1; i < 4; i++)
			canvas.add(new Rectangle("Rectangle #" + i, 10 + i * 4));	// Canvas have array list of drawable
		canvas.add(circle);
		canvas.add(text);
		
		try (FileOutputStream out = new FileOutputStream("note.txt", false))
		{
			canvas.draw(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ImageConverter img = ImageConverter.getInstance();
		char[][] art = img.makeArtByASCII("image.png", 10, 6);
		
		try (FileOutputStream out = new FileOutputStream("image.txt", false))
		{
			img.printArt(art, out);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int bytesInText = MemoryCounter.countBytesInText(text);
		int bytesInArt = MemoryCounter.countBytesInImage(art);
		System.out.println(String.format("\nInformation: text bytes size - %s ; bytesInArt - %s\n", bytesInText, bytesInArt));

		// LABORATOR 6 //
		// Cloning
		try {
			Circle anotherCircle = circle.clone();
			System.out.println("Check clone: Classes is the same? - " + (anotherCircle == circle));
			
			// Deep Cloning
			Canvas anotherCanvas = canvas.clone();
			System.out.println(
				"\nCheck deep clone: Classes is the same? - " + (anotherCanvas == canvas) +
				"\nList in classes is the same? - " +  (anotherCanvas.getList() == canvas.getList()));
		}
		catch (CloneNotSupportedException e) {
			e.getStackTrace();
		}
		// Generic class
		// We can create some objects from primitives
		GenericClass<Circle> ring = new GenericClass<Circle>(circle);
		System.out.println("Generic class: " + ring.getValue().toString());

		// Shape shape = new Shape(); Shape - Abstract class
	}
}