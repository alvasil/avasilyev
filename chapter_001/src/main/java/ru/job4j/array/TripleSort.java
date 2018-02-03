package ru.job4j.array;

public class TripleSort {
	public int[] bigSort(int[] arrayOne, int[] arrayTwo) {
		int[] bigArray = new int[arrayOne.length + arrayTwo.length];

		int firstIndex = 0, secondIndex = 0;
		for (int i = 0; i < bigArray.length; i++) {
			if (firstIndex >= arrayOne.length) {
				bigArray[i] = arrayTwo[secondIndex];
				secondIndex++;
			} else if (secondIndex >= arrayTwo.length) {
				bigArray[i] = arrayOne[firstIndex];
				firstIndex++;
			} else if (arrayOne[firstIndex] < arrayTwo[secondIndex]) {
				bigArray[i] = arrayOne[firstIndex];
				firstIndex++;
			} else {
				bigArray[i] = arrayTwo[secondIndex];
				secondIndex++;
			}
		}
		return bigArray;
	}
}
