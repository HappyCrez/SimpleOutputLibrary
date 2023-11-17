package swl;

import java.io.OutputStream;

public class Text implements Drawable{
	private String text;

	public Text(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	@Override
	public void draw(OutputStream stream) {
		try {
			stream.write(text.getBytes());
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
}
