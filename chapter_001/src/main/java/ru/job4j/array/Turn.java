package ru.job4j.array;

public class Turn {
	public int[] back(int[] array) {
		int fullArray = array.length;
		for (int out = 0; out < fullArray; out++) {
			int k = array[out];
			array[out] = array[fullArray - 1];
			array[fullArray - 1] = k;
			fullArray--;
		}
		return array;
	}
}
