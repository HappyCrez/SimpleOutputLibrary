package swl;

public class Rectangle extends Shape{
	
	public Rectangle( ) {
		this("title", 30);
	}
	
	public Rectangle(String title, int widgetSize) {
		this(0, 0, title, widgetSize);
	}
	
	public Rectangle(int coordX, int coordY, String title, int widgetSize) {
		super(coordX, coordY, title, widgetSize);
		this.widgetType = "Button";
	}

	@Override
	public void draw() {
		drawUpBound();
		outAtCenter(title);
		drawDownBound();
	}
}
