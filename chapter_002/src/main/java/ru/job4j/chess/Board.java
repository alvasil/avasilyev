package ru.job4j.chess;

public class Board {
	private int numberOfFigures = 0;
	private Figure[] figures = new Figure[32];

	public void add(Figure figure) {
		this.figures[numberOfFigures++] = figure;
	}

	public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		boolean canMove = false;
		for (Figure figure : this.figures) {
			if (figure != null) {
				if (!figure.position.equals(source)) {
					throw new FigureNotFoundException("figure is not on a cell");
				}

				Cell[] way = figure.way(source, dest);
				for (Cell cell : way) {
					if (cell == null) {
						throw new ImpossibleMoveException("impossible move");
					}

				}
				for (Cell cell : way) {
					if (cell.equals(figure.position)) {
						throw new OccupiedWayException("occupied by another figure");
					}
				}

				canMove = true;
				if (canMove) {
					figure.copy(dest);
				}
			}
		}
		return canMove;
	}
}


