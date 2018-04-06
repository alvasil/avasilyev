package ru.job4j.set;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SetHashTest {
	@Test
	public void whenAddToHashTable() {
		SetHash<Integer> set = new SetHash<>(5);
		for (int i = 1; i < 10; i++) {
			set.add(i);
			set.add(3); // не должны попасть в массив
			set.add(5); // не должны попасть в массив
			set.add(7); // не должны попасть в массив
			System.out.println("element: " + i);
		}
	}

	@Test
	public void whenTableContainsAndNot() {
		SetHash<Integer> set = new SetHash<>(5);
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		assertTrue(set.contains(1));
		assertTrue(set.contains(5));
		assertFalse(set.contains(66));
	}

	@Test
	public void whenRemoveFromTable() {
		SetHash<Integer> set = new SetHash<>(5);
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		assertTrue(set.remove(5));
		assertTrue(set.remove(2));
	}
}


