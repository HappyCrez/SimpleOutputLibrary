package swl;

import java.io.OutputStream;

public class Rectangle extends Shape{
	private int widgetSize;
	
	public Rectangle( ) {
		this("Title", 30);
	}
	
	public Rectangle(String title, int widgetSize) {
		this(0, 0, title, widgetSize);
	}
	
	public Rectangle(int coordX, int coordY, String title, int widgetSize) {
		super(coordX, coordY, title);
		this.shapeType = "Rectangle";
		this.widgetSize = widgetSize;
	}

	@Override
	public void draw(OutputStream stream) {
		drawUpBound();
		outAtCenter(title);
		drawDownBound();
	}
	

	private void drawUpBound() {
		String separator = createSeparator();
		System.out.printf("%s%s%s%n", "/", separator,"\\");
	}
	
	private void drawDownBound() {
		String separator = createSeparator();
		System.out.printf("%s%s%s%n", "\\", separator,"/");
	}
	
	private String createSeparator() {
		int padding = (widgetSize - 1) / 2;
		
		String separator = "";
		for (int i = 0; i < padding; i++) {			
			separator += " -";
		}
		separator += " ";
		
		return separator;
	}
	
	private void outAtCenter(String str) {
		int strSize = str.length();
		int padding = (int)((widgetSize - strSize) / 2);
		
		String separator = "";
		for (int i = 0; i < padding; i++)
			separator += " ";
		System.out.printf("%s%s%s%n", separator, str, separator);
	}
}
