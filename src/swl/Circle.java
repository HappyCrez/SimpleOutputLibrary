package swl;

public class Circle extends Shape{
	
	public Circle( ) {
		this("Title", 30);
	}
	
	public Circle(String title, int widgetSize) {
		this(0, 0, title, widgetSize);
	}
	
	public Circle(int coordX, int coordY, String title, int widgetSize) {
		super(coordX, coordY, title, widgetSize);
		this.widgetType = "Label"; 
	}
	
	@Override
	public void draw() {
		drawUpBound();
		outAtCenter(title);
		drawDownBound();
	}
}
