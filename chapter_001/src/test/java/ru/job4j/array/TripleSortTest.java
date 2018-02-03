package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class TripleSortTest {
	@Test
	public void whenTwoSortedArraysAndFirstBiggerThenOneSorted() {
		TripleSort twoArrays = new TripleSort();
		int[] result = twoArrays.bigSort(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6});
		int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7};
		assertArrayEquals(result, expected);
	}

	@Test
	public void whenTwoSortedArraysAndSecondBiggerThenOneSorted() {
		TripleSort twoArrays = new TripleSort();
		int[] result = twoArrays.bigSort(new int[]{1, 3}, new int[]{2, 4, 5, 6});
		int[] expected = new int[]{1, 2, 3, 4, 5, 6};
		assertArrayEquals(result, expected);
	}

	@Test
	public void whenTwoSortedArraysAndFirstHaveEqualsThenOneSorted() {
		TripleSort twoArrays = new TripleSort();
		int[] result = twoArrays.bigSort(new int[]{1, 1, 3}, new int[]{4, 5, 6});
		int[] expected = new int[]{1, 1, 3, 4, 5, 6};
		assertArrayEquals(result, expected);
	}

	@Test
	public void whenTwoSortedArraysAndSecondHaveEqualsThenOneSorted() {
		TripleSort twoArrays = new TripleSort();
		int[] result = twoArrays.bigSort(new int[]{1, 2, 3}, new int[]{4, 4});
		int[] expected = new int[]{1, 2, 3, 4, 4};
		assertArrayEquals(result, expected);
	}
}
