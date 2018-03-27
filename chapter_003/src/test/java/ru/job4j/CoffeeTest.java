package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CoffeeTest {
	@Test
	public void whenBigValueThanBigChange() {
		Coffee mashine = new Coffee();
		int[] result = mashine.changes(100, 37);
		int[] expected = {10, 10, 10, 10, 10, 10, 2, 1};
		assertThat(result, is(expected));
	}

	@Test
	public void whenSmallValueThanSmallChange() {
		Coffee mashine = new Coffee();
		int[] result = mashine.changes(50, 42);
		int[] expected = {5, 2, 1};
		assertThat(result, is(expected));
	}

	@Test
	public void whenValueEqualsPriceThanZeroChange() {
		Coffee mashine = new Coffee();
		int[] result = mashine.changes(50, 50);
		int[] expected = {0};
		assertThat(result, is(expected));
	}

	@Test(expected = ArithmeticException.class)
	public void whenValueSmallerThanPriceThanException() {
		Coffee mashine = new Coffee();
		int[] result = mashine.changes(40, 50);
	}

}
