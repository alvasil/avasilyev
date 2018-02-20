package ru.job4j.pseudo;

public class Paint {
	private Shape shape;

	public Paint(Shape shape) {
		this.shape = shape;
	}

	public void draw() {
		System.out.println(shape.draw());
	}

	public static void main(String[] args) {
		Paint triangle = new Paint(new Triangle());
		triangle.draw();
		Paint square = new Paint(new Square());
		square.draw();
	}
}
