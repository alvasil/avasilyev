package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * e.g. starting position of our bishop is {4,0}. If he moves diagonally, it's destination position will be {7,3}.
 * method way() must return an array with 2 elements: {5,1} и {6,2}.
 */

public class BishopTest {
	@Test
	public void passedCellsXFirstCoordinates() throws ImpossibleMoveException {
		Cell bishopStart = new Cell(4, 0);
		Cell bishopDest = new Cell(7, 3);
		Bishop bishop = new Bishop(bishopStart);
		Cell[] result = bishop.way(bishopStart, bishopDest);
		int firstPassedCell = result[0].getX();
		int expected = 5;
		assertThat(firstPassedCell, is(expected));
	}

	@Test
	public void passedCellsYFirstCoordinates() throws ImpossibleMoveException {
		Cell bishopStart = new Cell(4, 0);
		Cell bishopDest = new Cell(7, 3);
		Bishop bishop = new Bishop(bishopStart);
		Cell[] result = bishop.way(bishopStart, bishopDest);
		int firstPassedCell = result[0].getY();
		int expected = 1;
		assertThat(firstPassedCell, is(expected));
	}

	@Test
	public void passedCellsXSecondCoordinates() throws ImpossibleMoveException {
		Cell bishopStart = new Cell(4, 0);
		Cell bishopDest = new Cell(7, 3);
		Bishop bishop = new Bishop(bishopStart);
		Cell[] result = bishop.way(bishopStart, bishopDest);
		int firstPassedCell = result[1].getX();
		int expected = 6;
		assertThat(firstPassedCell, is(expected));
	}

	@Test
	public void passedCellsYSecondCoordinates() throws ImpossibleMoveException {
		Cell bishopStart = new Cell(4, 0);
		Cell bishopDest = new Cell(7, 3);
		Bishop bishop = new Bishop(bishopStart);
		Cell[] result = bishop.way(bishopStart, bishopDest);
		int firstPassedCell = result[1].getY();
		int expected = 2;
		assertThat(firstPassedCell, is(expected));
	}

	/**
	 * possibility move test. If a bishop can't move that way (not diagonally)- throw an exception.
	 */
	@Test(expected = ImpossibleMoveException.class)
	public void impossibleMove() throws ImpossibleMoveException {
		Cell bishopStart = new Cell(0, 0);
		Cell bishopDest = new Cell(3, 4);
		Bishop bishop = new Bishop(bishopStart);
		Cell[] result = bishop.way(bishopStart, bishopDest);
		int firstPassedCell = result[1].getY();
		assertThat(firstPassedCell, is("impossible move"));
	}
}
