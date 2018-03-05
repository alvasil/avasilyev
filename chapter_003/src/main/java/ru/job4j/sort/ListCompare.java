package ru.job4j.sort;

import java.util.Comparator;

/**
 * Вам нужно реализовать компаратор для сравнения двух массивов символов.
 * Необходимо реализовать поэлементное сравнение двух списков,
 * т.е. сравниваем элементы двух списков, находящихся на одних и тех же позициях (по одним и тем же индексом).
 */
public class ListCompare implements Comparator<String> {

	@Override
	public int compare(String first, String second) {
		char[] firstArray = first.toCharArray();
		char[] secondArray = second.toCharArray();
		int min = Math.min(firstArray.length, secondArray.length);
		int flag = 0;
		for (int i = 0; i < min; i++) {
			if (firstArray[i] == secondArray[i]) {
				flag = flag + firstArray[i] - secondArray[i];
			} else if (firstArray[i] < secondArray[i]) {
				flag = flag + firstArray[i] - secondArray[i];
			} else if (firstArray[i] > secondArray[i]) {
				flag = flag + firstArray[i] + secondArray[i];
			}
		}
		if (flag > 0) {
			flag = 1;
		} else if (firstArray.length < secondArray.length && flag == 0) {
			flag = -1;
		}
		return flag;
	}
}

