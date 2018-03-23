package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SetArrayTest {
	@Test
	public void whenAddToSet() {
		SetArray<Integer> set = new SetArray<>(10);
		set.add(1);
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(2);
		set.add(4);
		Iterator it = set.iterator();
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(4));
	}
}
