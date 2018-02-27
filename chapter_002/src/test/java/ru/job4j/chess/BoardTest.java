package ru.job4j.chess;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoardTest {
	@Test
	//  проверка что в заданной ячейке есть фигура. если нет, то выкинуть исключение
	public void whenCellContainsFigure() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException{
		Cell cellStart = new Cell(0, 0);
		Cell cellDest = new Cell(3, 3);
		Cell bishopAddPos = new Cell(0,0);
		Bishop bishop = new Bishop(bishopAddPos);
		Board board = new Board();
		board.add(bishop);
		Boolean result = board.move(cellStart, cellDest);
		assertTrue(result);
	}
}
