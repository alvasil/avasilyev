package ru.job4j.chess;

public class Board {
	private int numberOfFigures = 0;
	public Figure[] figures = new Figure[32];

	public Figure add(Figure figure) {
		this.figures[numberOfFigures++] = figure;
		return figure;
	}

	public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		boolean canMove = false;
		for (int index = 0; index < numberOfFigures; index++) {
			if (this.figures[index] != null && (this.figures[index].position.getX() == source.getX()) && this.figures[index].position.getY() == source.getY()) {
				canMove = true;
			} else {
				throw new FigureNotFoundException("figure is not on a cell");
			}
			Cell[] way = this.figures[index].way(source, dest);
			for (int i = 0; i < way.length; i++) {
				if (way[i] != null) {
					canMove = true;
				} else {
					throw new ImpossibleMoveException("impossible move");
				}
			}
			for (Cell cell : way) {
				if (cell.getX() != this.figures[index].position.getX() && cell.getY() != this.figures[index].position.getY()) {
					canMove = true;
				} else {
					throw new OccupiedWayException("occupied by another figure");
				}
			}
			if (canMove) {
				this.figures[index].copy(dest);
			}
		}
		return canMove;
	}
}


