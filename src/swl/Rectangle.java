package swl;

import java.io.OutputStream;

public class Rectangle extends Shape{
	private int width;
	
	public Rectangle( ) {
		this("Title", 30);
	}
	
	public Rectangle(String title, int width) {
		this(0, 0, title, width);
	}
	
	public Rectangle(int coordX, int coordY, String title, int width) {
		super(coordX, coordY, title);
		this.shapeType = "Rectangle";
		this.width = width;
	}

	@Override
	public void draw(OutputStream stream) {
		drawUpBound(stream);
		outAtCenter(stream, title);
		drawDownBound(stream);
	}
	

	private void drawUpBound(OutputStream stream) {
		String separator = createSeparator();
		separator = "/" + separator + "\\\n";
		try {
			stream.write(separator.getBytes());
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private void drawDownBound(OutputStream stream) {
		String separator = createSeparator();
		separator = "\\" + separator + "/\n";
		try {
			stream.write(separator.getBytes());
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private String createSeparator() {
		int padding = (width - 1) / 2;
		
		String separator = "";
		for (int i = 0; i < padding; i++) {			
			separator += " -";
		}
		separator += " ";
		
		return separator;
	}
	
	private void outAtCenter(OutputStream stream, String str) {
		int strSize = str.length();
		int padding = (int)((width - strSize) / 2);
		
		String separator = "";
		for (int i = 0; i < padding; i++)
			separator += " ";
		
		try {
			stream.write(separator.getBytes());
			stream.write(str.getBytes());
			stream.write(separator.getBytes());
			stream.write("\n".getBytes());
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
}
