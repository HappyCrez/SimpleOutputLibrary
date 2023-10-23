package swl;

import java.io.OutputStream;
import java.util.ArrayList;

public class Canvas {

	private ArrayList<Drawable> matrix;
	
	public Canvas() {
		matrix = new ArrayList<Drawable>();
	}

	public Canvas(ArrayList<Drawable> matrix) {
		this.matrix = matrix;
	}
	
	public void add(Drawable elem) {
		matrix.add(elem);
	}
	
	public void clear() {
		for (int i = 0; i < 30; i++)
			System.out.printf("%n");
	}
	
	public void draw(OutputStream stream) {
		for (Drawable elem : matrix) {
			elem.draw(stream);
		}
	}
}
