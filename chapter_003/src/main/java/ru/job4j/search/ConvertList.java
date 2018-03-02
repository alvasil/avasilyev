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

	/**
	 * В этом методе вы должны пройтись по всем элементам всех массивов в списке list и добавить их в один общий лист Integer.
	 * Массивы в списке list могут быть разного размера.
	 *
	 * @param list - массив в списке list
	 * @return - общий лист Integer.
	 */
	public List<Integer> convert(List<int[]> list) {
		for (int[] array : list) {
			for (int item : array) {
				this.listFromArray.addLast(item);
			}
		}
		return this.listFromArray;
	}

	/**
	 * метод добавляет входящий массив в лист с массивами.
	 *
	 * @param array - входящий одномерный массив.
	 * @return - лист, который хранит массивы.
	 */
	public List<int[]> add(int[] array) {
		List<int[]> result = new LinkedList<>();
		result.add(array);
		return result;
	}
}
