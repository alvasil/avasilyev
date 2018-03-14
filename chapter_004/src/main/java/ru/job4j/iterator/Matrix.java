package ru.job4j.iterator;

import java.util.Iterator;

public class Matrix implements Iterator {
	private final int[][] values;
	private int row = 0;
	private int col = 0;

	public Matrix(final int[][] values) {
		this.values = values;
	}

	@Override
	public boolean hasNext() {
		boolean result = false;
		if (this.values.length > row) {
			result = true;
		}
		return result;
	}

	@Override
	public Object next() {
		int result = this.values[row][col];
		if (this.values[row].length > col) {
			col++;
		}
		if (this.values[row].length == col) {
			row++;
			col = 0;
		}
		return result;
	}
}

