package ru.job4j.chess;

public abstract class Figure {
	final Cell position;

	public Figure(Cell position) {
		this.position = position;
	}

	/**
	 * @param source - задает начальную позицию фигуры
	 * @param dest   - задает ячейку, куда следует пойти
	 */
	abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

	abstract Figure copy(Cell dest);
}
