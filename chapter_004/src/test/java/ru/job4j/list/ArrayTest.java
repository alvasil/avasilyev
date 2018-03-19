package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ArrayTest {
	@Test
	public void whenCreateNewArrayList() {
		Array arrayList = new Array(2);
		for (int i = 0; i < 5; i++) {
			arrayList.add(i);
		}
		assertThat(arrayList.get(0), is(0));
		assertThat(arrayList.get(1), is(1));
		assertThat(arrayList.get(2), is(2));
		assertThat(arrayList.get(3), is(3));
		assertThat(arrayList.get(4), is(4));
	}

	@Test(expected = ConcurrentModificationException.class)
	public void whenIterate() {
		Array arrayList = new Array(2);
		Iterator it = arrayList.iterator();
		assertThat(it.hasNext(), is(false));
		assertTrue(it.next() == null);

		for (int i = 0; i < 5; i++) {
			arrayList.add(i);
		}
		it.hasNext();
	}

}
