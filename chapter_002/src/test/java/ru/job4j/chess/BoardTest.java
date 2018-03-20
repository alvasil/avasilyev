package ru.job4j.chess;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoardTest {
	@Test
	//  проверка что в заданной ячейке есть фигура
	public void whenCellContainsFigure() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		Cell cellStart = new Cell(0, 0);
		Cell cellDest = new Cell(3, 3);
		Bishop bishop = new Bishop(new Cell(0, 0));
		Board board = new Board();
		board.add(bishop);
		Boolean result = board.move(cellStart, cellDest);
		assertTrue(result);
	}

	// если в ячейке нет фигуры
	@Test(expected = FigureNotFoundException.class)
	public void whenCellNotContainsFigure() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		Cell cellStart = new Cell(0, 0);
		Cell cellDest = new Cell(3, 3);
		Cell bishopAddPos = new Cell(0, 1);
		Bishop bishop = new Bishop(bishopAddPos);
		Board board = new Board();
		board.add(bishop);
		Boolean result = board.move(cellStart, cellDest);
		assertTrue(result);
	}

	// если такой ход невозможен
	@Test(expected = ImpossibleMoveException.class)
	public void whenImpossibleMove() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		Cell cellStart = new Cell(0, 0);
		Cell cellDest = new Cell(3, 4);
		Bishop bishop = new Bishop(new Cell(0, 0));
		Board board = new Board();
		board.add(bishop);
		Boolean result = board.move(cellStart, cellDest);
		assertTrue(result);
	}
}
