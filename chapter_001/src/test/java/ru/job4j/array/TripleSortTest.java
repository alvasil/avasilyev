package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class TripleSortTest {
	@Test
	public void whenTwoUnsortedArraysThenOneSorted() {
		TripleSort twoArrays = new TripleSort();
		int[] result = twoArrays.bigSort(new int[] {3, 4, 1, 7}, new int[] {5, 2, 6});
		int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7};
		assertArrayEquals(result, expected);
	}
}
