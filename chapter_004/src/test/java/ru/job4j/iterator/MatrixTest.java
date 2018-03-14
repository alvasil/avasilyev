package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MatrixTest {

	private Matrix it;

	@Before
	public void setUp() {
		it = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}});
	}

	@Test
	public void hasNextNextSequentialInvocation() {
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(1));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(2));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(3));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(4));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(5));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(6));
		assertThat(it.hasNext(), is(false));
	}

	@Test
	public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(5));
		assertThat(it.next(), is(6));
	}

	@Test
	public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
		assertThat(it.hasNext(), is(true));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(5));
		assertThat(it.next(), is(6));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void shoulThrowNoSuchElementException() {
		it = new Matrix(new int[][]{});
		it.next();
	}
}