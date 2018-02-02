package ru.job4j.array;

public class TripleSort {
	public int[] bigSort(int[] arrayOne, int[] arrayTwo) {
		int i = 0, j = 0, k = 0;
		int[] bigArray = new int[arrayOne.length + arrayTwo.length];

		while (i < arrayOne.length && j < arrayTwo.length) {
			bigArray[k] = arrayOne[i] < arrayTwo[j] ? arrayOne[i] : arrayTwo[j];
			bigArray[k + 1] = arrayTwo[j] > arrayOne[i] ? arrayTwo[j] : arrayOne[i];
			k = k + 2;
			i++;
			j++;
		}
		while(i >= arrayOne.length && k < bigArray.length) {
			bigArray[k] = arrayTwo[j];
			j++;
			k++;
		}
		while (j >= arrayTwo.length && k < bigArray.length) {
			bigArray[k] = arrayOne[i];
			i++;
			k++;
		}
		return bigArray;
	}
}
