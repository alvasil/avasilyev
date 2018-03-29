package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
	@Test
	public void whenAddEqualsKeysThenOnlyOneInMap() {
		SimpleHashMap<Integer, String> map = new SimpleHashMap<>(10);
		boolean first = map.insert(1, "first");
		boolean second = map.insert(1, "second");
		assertTrue(first);
		assertFalse(second);
	}

	@Test
	public void whenAddDiffKeysThenDiffInMap() {
		SimpleHashMap<Integer, String> map = new SimpleHashMap<>(10);
		boolean first = map.insert(1, "one");
		boolean second = map.insert(2, "two");
		boolean third = map.insert(3, "three");
		boolean fourth = map.insert(4, "four");
		boolean fifth = map.insert(5, "five");
		assertTrue(first);
		assertTrue(second);
		assertTrue(third);
		assertTrue(fourth);
		assertTrue(fifth);
	}

	@Test
	public void whenAddDiffKeysThenFindByKey() {
		SimpleHashMap<Integer, String> map = new SimpleHashMap<>(10);
		map.insert(1, "one");
		map.insert(2, "two");
		map.insert(3, "three");
		map.insert(4, "four");
		map.insert(5, "five");
		assertThat(map.get(3), is("three"));
	}

	@Test
	public void whenDeleteKeyThenNullItem() {
		SimpleHashMap<Integer, String> map = new SimpleHashMap<>(10);
		map.insert(1, "one");
		map.insert(2, "two");
		map.insert(3, "three");
		map.insert(4, "four");
		map.insert(5, "five");
		boolean del = map.delete(3);
		assertTrue(del);
	}

	@Test
	public void whenIterateNext() {
		SimpleHashMap<Integer, String> map = new SimpleHashMap<>(10);
		Iterator it = map.iterator();
		map.insert(1, "one");
		map.insert(2, "two");
		map.insert(3, "three");
		assertTrue(it.hasNext());
		assertThat(it.next(), is("one"));
		assertTrue(it.hasNext());
		assertThat(it.next(), is("two"));
		assertTrue(it.hasNext());
		assertThat(it.next(), is("three"));
		assertFalse(it.hasNext());
	}

}
