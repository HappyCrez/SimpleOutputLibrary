package swl;

import java.io.OutputStream;
import java.io.IOException;
import java.lang.Cloneable;

public class Shape implements Drawable, Cloneable{
	protected int[] location = {0, 0};
	protected String title;
	protected String shapeType;
	
	public Shape() {
		this("shape");
	}
	
	public Shape(String title) {
		this(0, 0, title);
	}
	
	public Shape(int coordX, int coordY, String title) {
		this.title = title;
		this.location[0] = coordX;
		this.location[1] = coordY;
		this.shapeType = "shape";
	}
	
	public void draw(OutputStream stream) {
		try {
			stream.write("It's shape method!\n".getBytes());
		}
		catch (IOException e) {
			e.getStackTrace();
		}
	}

	@Override
	public String toString() {
		return shapeType;
	}

	@Override
	public Shape clone() throws CloneNotSupportedException {
		return (Shape) super.clone();
	}
}