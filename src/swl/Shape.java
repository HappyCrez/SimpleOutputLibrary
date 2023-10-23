package swl;

public abstract class Shape implements Drawable{
	protected int[] location = {0, 0};
	protected String title;
	protected int widgetSize;
	protected String widgetType;
	
	public Shape() {
		this("widget", 30);
	}
	
	public Shape(String title, int widgetSize) {
		this(0, 0, title, widgetSize);
	}
	
	public Shape(int coordX, int coordY, String title, int widgetSize) {
		this.title = title;
		this.location[0] = coordX;
		this.location[1] = coordY;
		this.widgetType = "widget"; 
		this.widgetSize = widgetSize;
	}
	
	public abstract void draw();

	@Override
	public String toString() {
		return widgetType;
	}
	

	protected void drawUpBound() {
		String separator = createSeparator();
		System.out.printf("%s%s%s%n", "⌜", separator,"⌝");
	}
	
	protected void drawDownBound() {
		String separator = createSeparator();
		System.out.printf("%s%s%s%n", "⌞", separator,"⌟");
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

	protected void outAtCenter(String str) {
		int strSize = str.length();
		int padding = (int)((widgetSize - strSize) / 2);
		
		String separator = "";
		for (int i = 0; i < padding; i++)
			separator += " ";
		System.out.printf("%s%s%s%n", separator, str, separator);
	}
}
