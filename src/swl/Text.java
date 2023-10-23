package swl;

import java.io.OutputStream;

public class Text implements Drawable{
	String text;

	public Text(String text) {
		this.text = text;
	}
	
	@Override
	public void draw(OutputStream stream) {
		System.out.print(text);
	}
}
