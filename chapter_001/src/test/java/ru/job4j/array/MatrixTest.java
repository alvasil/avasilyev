package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenTwoMultiplyTwoThenFour() {
        Matrix matrix = new Matrix();
        int[][] result = matrix.multiple(5);
        assertThat(result[2][2], is (4));
    }
}