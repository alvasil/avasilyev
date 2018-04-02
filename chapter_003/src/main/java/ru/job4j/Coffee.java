package ru.job4j;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Coffee {
	private int ten = 10;
	private int five = 5;
	private int two = 2;
	private int one = 1;

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
					result[i] = ten;
					change = change - ten;
					size++;
					break;
				}
				if (change >= 5 && change < 10) {
					result[i] = five;
					change = change - five;
					size++;
					break;

				}
				if (change >= 2 && change < 5) {
					result[i] = two;
					change = change - two;
					size++;
					break;

				}
				if (change == 1) {
					result[i] = one;
					change = change - one;
					size++;
					break;
				}
			}
		}
		return Arrays.copyOf(result, size);
	}
}


