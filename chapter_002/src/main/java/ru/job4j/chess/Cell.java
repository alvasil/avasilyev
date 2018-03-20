package ru.job4j.chess;

import java.util.Objects;

public class Cell {
	private int x;
	private int y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Cell cell = (Cell) o;
		return x == cell.x && y == cell.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
