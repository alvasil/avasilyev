package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
	@Test
	public void whenTwoMultiplyTwoThenFour() {
		Matrix matrix = new Matrix();
		int[][] result = matrix.multiple(5);
		assertThat(result[1][1], is(4));
	}

	@Test
	public void whenOneMultiplyOneThenOne() {
		Matrix matrix = new Matrix();
		int[][] result = matrix.multiple(5);
		assertThat(result[0][0], is(1));
	}
}