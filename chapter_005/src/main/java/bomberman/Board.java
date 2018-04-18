package bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Board {
	private final ReentrantLock[][] board;
	private ReentrantLock lock = new ReentrantLock();
	private Cell heroPos;
	private int sizeX;
	private int sizeY;

	public Board(int sizeX, int sizeY) {
		this.board = new ReentrantLock[sizeX][sizeY];
	}

	/**
	 * @param cell - начальное положение героя
	 */
	public void init(Cell cell) throws InterruptedException {
		Thread play = new Thread() {
			@Override
			public void run() {
				heroPos = cell;
				if (heroPos.getX() > sizeX || heroPos.getY() > sizeY) {
					throw new UnsupportedOperationException("Hero out of the board");
				} else {
					lock.lock();
					try {
						Cell newCell = move(cell);
						if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
							heroPos = newCell;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		play.start();
		play.join();
	}

	/**
	 * Генерирует новые координаты героя, смещая начальные на [-1; 1].
	 *
	 * @param cell - начальное положение героя
	 * @return - новое положение
	 */
	public Cell move(Cell cell) {
		int newX = cell.getX() + (-1 + (int) (Math.random() * 3));
		int nexY = cell.getY() + (-1 + (int) (Math.random() * 3));
		return new Cell(newX, nexY);
	}
}
