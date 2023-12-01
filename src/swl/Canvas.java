package swl;

import java.io.OutputStream;
import java.util.ArrayList;
import java.lang.Cloneable;

public class Canvas implements Cloneable{

	private ArrayList<Drawable> matrix;
	
	public Canvas() {
		matrix = new ArrayList<Drawable>();
	}

	public Canvas(ArrayList<Drawable> matrix) {
		this.matrix = matrix;
	}

	public void set(ArrayList<Drawable> list) {
		matrix = list;
	}
	
	public void add(Drawable elem) {
		matrix.add(elem);
	}

	public ArrayList<Drawable> getList() {
		return matrix;
	}
	
	public void draw(OutputStream stream) {
		for (Drawable elem : matrix) {
			elem.draw(stream);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Canvas clone() throws CloneNotSupportedException {
		Canvas canvas = (Canvas) super.clone();
		ArrayList<Drawable> matrix = (ArrayList<Drawable>) this.matrix.clone();
		canvas.set(matrix);
		return canvas;
	}
}