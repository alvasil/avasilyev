package ru.job4j.array;

public class TripleSort {
	public int[] sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int k = array[i];
					array[i] = array[j];
					array[j] = k;
				}
			}
		}
		return array;
	}

	public int[] bigSort(int[] arrayOne, int[] arrayTwo) {
		int[] bigArray = new int[arrayOne.length + arrayTwo.length];
		System.arraycopy(sort(arrayOne), 0, bigArray, 0, arrayOne.length);
		System.arraycopy(sort(arrayTwo), 0, bigArray, arrayOne.length, arrayTwo.length);
		return sort(bigArray);
	}
}
