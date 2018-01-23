package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SquareTest {
    @Test
    public void whenBoundThreeElementsOneFourNine() {
        Square square = new Square();
        int[] result = square.calculate(3);
        assertArrayEquals(result, new int[]{1, 4, 9});
    }
}
