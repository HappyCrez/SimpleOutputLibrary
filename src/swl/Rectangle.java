package swl;

import java.io.OutputStream;
import java.io.IOException;

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

	public void draw(OutputStream stream) {
		super.draw(stream);
		try {
			drawUpBound(stream);
			outAtCenter(stream, title);
			drawDownBound(stream);
		}
		catch (IOException e) {
			e.getStackTrace();
		}
	}

	private void drawUpBound(OutputStream stream) throws IOException{
		String separator = createSeparator();
		separator = "/" + separator + "\\\n";
		stream.write(separator.getBytes());
	}
	
	private void drawDownBound(OutputStream stream) throws IOException{
		String separator = createSeparator();
		separator = "\\" + separator + "/\n";
		stream.write(separator.getBytes());
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
	
	private void outAtCenter(OutputStream stream, String str) throws IOException{
		int strSize = str.length();
		int padding = (int)((width - strSize) / 2);
		
		String separator = "";
		for (int i = 0; i < padding; i++)
			separator += " ";

		stream.write(separator.getBytes());
		stream.write(str.getBytes());
		stream.write(separator.getBytes());
		stream.write("\n".getBytes());
	}

	@Override
	public Rectangle clone() throws CloneNotSupportedException {
		return (Rectangle) this.clone();
	}
}
