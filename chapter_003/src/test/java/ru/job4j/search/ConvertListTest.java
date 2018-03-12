package ru.job4j.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
	@Test
	public void whenArrayToListAndBackToArray() {
		int[][] testArray = {{1, 2, 3}, {4, 5, 6}};
		ConvertList list = new ConvertList();
		List<Integer> listFromArray = list.toList(testArray);
		int[][] result = list.toArray(listFromArray, 4);
		int[][] expArray = {{1, 2}, {3, 4}, {5, 6}, {0, 0}};
		assertArrayEquals(result, expArray);
	}

	@Test
	public void whenSeveralArraysToListThenNewList() {
		int[] testArrayFirst = {1, 2};
		int[] testArraySecond = {3, 4, 5};
		ConvertList list = new ConvertList();
		List<int[]> arrayInList = list.add(testArrayFirst);
		arrayInList.add(testArraySecond);
		List<Integer> result = list.convert(arrayInList);
		int[] expArray = {1, 2, 3, 4, 5 };
		assertThat(result.toArray(), is(expArray));
	}

	@Test
	public void whenFixedSizeArrayToListAndBackToArray() {
		ConvertList list = new ConvertList();
		List<Integer> listFromArray = Arrays.asList(1,2,3);
		int[][] result = list.toArray(listFromArray, 4);
		int[][] expArray = {{1}, {2}, {3}, {0}};
		assertArrayEquals(result, expArray);
	}
}
