package swl;

import java.io.OutputStream;

public class Circle extends Shape{
	
	private int radius;
	
	public Circle( ) {
		this("Title", 5);
	}
	
	public Circle(String title, int radius) {
		this(0, 0, title, radius);
	}
	
	public Circle(int coordX, int coordY, String title, int radius) {
		super(coordX, coordY, title);
		this.shapeType = "Circle"; 
		this.radius = radius;
	}
	
	@Override
	public void draw(OutputStream stream) {
		String circle = "";
		for (int i = radius - 1 - (radius / 5); i > 0; i--) {
			String start = "";
			for (int k = 0; k < i*i; k++)
				start += " ";
			String end = "";
			for (int k = 0; k < radius * radius - i*i - start.length(); k++)
				end += " ";
			circle += start + "*" + end + "*" + "\n";
		}
		
		for (int i = 0; i < radius - (radius / 5); i++) {
			//int x = (int)Math.sqrt(radius * radius - i * i);
			String start = "";
			for (int k = 0; k < i*i; k++)
				start += " ";
			String end = "";
			for (int k = 0; k < radius * radius - i*i - start.length(); k++)
				end += " ";
			if (i == 0 && title.length() < end.length()) {
				int padding = (end.length() - title.length()) / 2;
				String paddingStr = end.substring(0, padding);
				end = paddingStr + title + paddingStr;
				if (title.length() % 2 == 1)
					end += " ";
			}
			circle += start + "*" + end + "*" + "\n";
		}
		
		try {
			stream.write(circle.getBytes());
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
}
