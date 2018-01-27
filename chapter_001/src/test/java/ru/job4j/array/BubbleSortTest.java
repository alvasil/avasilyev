package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {
    @Test
    public void whenWrongArrayFourElementsThenOneTwoThreeFour() {
        BubbleSort wrongArray = new BubbleSort();
        int[] result = wrongArray.sort(new int[]{4, 1, 3, 2});
        assertArrayEquals(result, new int[]{1, 2, 3, 4});
    }
}
