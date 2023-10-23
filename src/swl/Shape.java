package swl;

public abstract class Shape implements Drawable{
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
	
	public abstract void draw();

	@Override
	public String toString() {
		return shapeType;
	}
}
