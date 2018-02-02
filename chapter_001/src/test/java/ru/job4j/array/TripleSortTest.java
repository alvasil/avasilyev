package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class TripleSortTest {
	@Test
	public void whenTwoUnsortedArraysThenOneSorted() {
		TripleSort twoArrays = new TripleSort();
		int[] result = twoArrays.bigSort(new int[] {1, 3, 5, 10, 99}, new int[] {2, 4, 6, 11, 12});
		int[] expected = new int[] {1, 2, 3, 4, 5, 6, 10, 11, 12, 99};
		assertArrayEquals(result, expected);
	}
}
