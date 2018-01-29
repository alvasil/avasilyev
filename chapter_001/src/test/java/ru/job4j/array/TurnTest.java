package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TurnTest {
    @Test
    public void whenArrayFourElementsThenFourThreeTwoOne() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[] {1, 2, 5, 6});
        assertArrayEquals(result, new int[]{6, 5, 2, 1});
    }
    @Test
    public void whenArrayFiveElementsThenFiveFourThreeTwoOne() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[] {9, 2, 3, 4, 1});
        assertArrayEquals(result, new int[]{1, 4, 3, 2, 9});
    }
}
