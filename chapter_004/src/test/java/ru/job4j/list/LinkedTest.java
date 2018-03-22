package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LinkedTest {
	@Test
	public void whenCreateLinkedList() {
		Linked<Integer> list = new Linked<>();
		list.add(1); // index 0
		list.add(2); // index 1
		list.add(3); // index 2
		list.add(4); // index 3
		assertThat(list.get(0), is(1));
		assertThat(list.get(1), is(2));
		assertThat(list.get(2), is(3));
		assertThat(list.get(3), is(4));

	}

	@Test(expected = NoSuchElementException.class)
	public void whenSizeLessThanIndex() {
		Linked<Integer> list = new Linked<>();
		list.add(1);
		list.add(2);
		assertThat(list.get(3), is(1));
	}

	@Test
	public void iteratorTest() {
		Linked<Integer> list = new Linked<>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator it = list.iterator();
		assertThat(it.next(), is(1));
		assertTrue(it.hasNext());
		assertThat(it.next(), is(2));
		assertTrue(it.hasNext());
		assertThat(it.next(), is(3));
		assertFalse(it.hasNext());
	}

	@Test(expected = ConcurrentModificationException.class)
	public void listModifiedAfterIterator() {
		Linked<Integer> list = new Linked<>();
		list.add(1);
		list.add(2);
		Iterator it = list.iterator();
		list.add(3);
		assertThat(it.next(), is(1));
		assertTrue(it.hasNext());
	}
}
