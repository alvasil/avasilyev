package ru.job4j.search;

import java.util.LinkedList;
import java.util.List;

public class ConvertList {
	private LinkedList<Integer> listFromArray = new LinkedList<>();

	/**
	 * в метод приходит двумерный массив целых чисел, необходимо пройтись по всем элементам массива и добавить их в List<Integer>.
	 * использовать foreach.
	 *
	 * @param array - входящий массив.
	 * @return - возвращает лист.
	 */
	public List<Integer> toList(int[][] array) {
		for (int[] x : array) {
			for (int y : x) {
				this.listFromArray.add(y);
			}
		}
		return this.listFromArray;
	}

	/**
	 * метод toArray должен равномерно разбить лист на количество строк двумерного массива.
	 * В методе toArray должна быть проверка - если количество элементов не кратно количеству строк - оставшиеся значения в массиве заполнять нулями.
	 * использовать foreach.
	 *
	 * @param list - входящий List.
	 * @param rows - количество строк.
	 * @return - возвращает двумерный массив.
	 */
	public int[][] toArray(List<Integer> list, int rows) {
		while (list.size() % rows != 0) {
			list.add(0);
		}
		int listPos = 0;
		int[][] arrayFromList = new int[rows][list.size() / rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < list.size() / rows; j++) {
				arrayFromList[i][j] = list.get(listPos);
				listPos++;
			}
		}
		return arrayFromList;
	}
}
