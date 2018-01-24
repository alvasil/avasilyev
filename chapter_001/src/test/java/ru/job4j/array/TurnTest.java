package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TurnTest {
    @Test
    public void whenArrayFourElementsThenFourThreeTwoOne() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[4]);
        assertArrayEquals(result, new int[]{4, 3, 2, 1});
    }
    @Test
    public void whenArrayFiveElementsThenFiveFourThreeTwoOne() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[5]);
        assertArrayEquals(result, new int[]{5, 4, 3, 2, 1});
    }
}
