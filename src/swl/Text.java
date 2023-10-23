package swl;

public class Text implements Drawable{
	String text;

	public Text(String text) {
		this.text = text;
	}
	
	@Override
	public void draw() {
		System.out.print(text);
	}
}
