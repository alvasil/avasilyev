package ru.job4j.chess;

import java.util.Arrays;

public class Bishop extends Figure {

	public Bishop(Cell position) {
		super(position);
	}

	/**
	 * @param sourse - начальное положение фигуры.
	 * @param dest   - задает ячейку, куда следует пойти.
	 * @return - массив пройденных ячеек.
	 * @throws ImpossibleMoveException - в случае невозможности хода.
	 */
	@Override
	public Cell[] way(Cell sourse, Cell dest) throws ImpossibleMoveException {
		Cell[] way = new Cell[6];
		int index = 0;
		int cellPassX = sourse.getX();
		int cellPassY = sourse.getY();
		if ((Math.abs(sourse.getX() - dest.getX()) - Math.abs(sourse.getY() - dest.getY())) == 0) {
			while (cellPassX < dest.getX()) {
				way[index] = new Cell(cellPassX + 1, cellPassY + 1);
				cellPassX++;
				cellPassY++;
				index++;
			}
		} else throw new ImpossibleMoveException("impossible direction");
		return Arrays.copyOf(way, index);
	}

	@Override
	public Figure copy(Cell dest) {
		return new Bishop(dest);
	}
}
