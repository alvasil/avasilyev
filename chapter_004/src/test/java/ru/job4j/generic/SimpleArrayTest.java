package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleArrayTest {
	@Test
	public void whenCreateNewIntegerArray() {
		SimpleArray<Integer> numbers = new SimpleArray<>(10);
		numbers.add(1);
		numbers.add(2);
		assertThat(numbers.get(0), is(1));
		numbers.set(0, 100);
		assertThat(numbers.get(0), is(100));
	}

	@Test
	public void whenCreateNewStringArray() {
		SimpleArray<String> numbers = new SimpleArray<>(10);
		numbers.add("first");
		numbers.add("second");
		assertThat(numbers.get(0), is("first"));
		numbers.set(0, "NEW VALUE");
		assertThat(numbers.get(0), is("NEW VALUE"));
	}

	@Test
	public void whenDeleteArrayElement() {
		SimpleArray<Integer> numbers = new SimpleArray<>(10);
		numbers.add(1); //index 0
		numbers.add(2); //index 1
		numbers.add(3); //index 2
		numbers.delete(1);
		assertThat(numbers.get(1), is(3));
	}


	@Test
	public void whenIterate() {
		SimpleArray<Integer> numbers = new SimpleArray<>(10);
		numbers.add(1);
		numbers.add(2);
		Iterator it = numbers.iterator();
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(1));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(2));
		assertThat(it.hasNext(), is(false));
	}
}
