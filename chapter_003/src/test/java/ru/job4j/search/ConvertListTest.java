package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

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
}
