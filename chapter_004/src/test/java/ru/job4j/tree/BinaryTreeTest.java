package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {
	@Test
	public void whenAddElemToTreeThenItisBinary() {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.add(50);
		tree.add(25);
		tree.add(75);
		tree.add(10);
		tree.add(30);
		Iterator it = tree.iterator();
		assertThat(it.next(), is(10));
		assertTrue(it.hasNext());
		assertThat(it.next(), is(25));
		assertTrue(it.hasNext());
		assertThat(it.next(), is(30));
		assertTrue(it.hasNext());
		assertThat(it.next(), is(50));
		assertTrue(it.hasNext());
		assertThat(it.next(), is(75));
		assertFalse(it.hasNext());


	}
}
