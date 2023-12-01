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

	public void setText(String text) {
		this.text = text;
	}

	public String addText(String text) {
		this.text += text;
		return this.text;
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