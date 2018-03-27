package ru.job4j;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Coffee {
	private final int TEN = 10;
	private final int FIVE = 5;
	private final int TWO = 2;
	private final int ONE = 1;

	/**
	 * Метод должен вернуть наименьшее количество монет.
	 *
	 * @param value - вставляемая в аппарат купюра.
	 * @param price - цена кофе.
	 * @return - сдача в виде массива (монеты номиналом 1, 2, 5, 10).
	 */

	public int[] changes(int value, int price) throws NoSuchElementException {
		int[] result = new int[10];
		int size = 0;
		int change = value - price;
		if (change < 0) {
			throw new ArithmeticException();
		}
		if (change == 0) {
			result[0] = 0;
			size = 1;
		}
		for (int i = 0; i < result.length; i++) {
			while (change != 0) {
				if (change >= 10) {
					result[i] = TEN;
					change = change - TEN;
					size++;
					break;
				}
				if (change >= 5 && change < 10) {
					result[i] = FIVE;
					change = change - FIVE;
					size++;
					break;

				}
				if (change >= 2 && change < 5) {
					result[i] = TWO;
					change = change - TWO;
					size++;
					break;

				}
				if (change == 1) {
					result[i] = ONE;
					change = change - ONE;
					size++;
					break;
				}
			}
		}
		return Arrays.copyOf(result, size);
	}
}


