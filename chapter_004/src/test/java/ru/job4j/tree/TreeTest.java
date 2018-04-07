package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TreeTest {
	@Test
	public void when6ElFindLastThen6() {
		Tree<Integer> tree = new Tree<>(1);
		tree.add(1, 2);
		boolean testParent = tree.add(1, 2);
		assertFalse(testParent);
		tree.add(1, 3);
		tree.add(1, 4);
		tree.add(4, 5);
		boolean testChild = tree.add(4, 5);
		assertFalse(testChild);
		tree.add(5, 6);
		assertThat(tree.findBy(6).isPresent(), is(true));
	}

	@Test
	public void when6ElFindNotExitThenOptionEmpty() {
		Tree<Integer> tree = new Tree<>(1);
		tree.add(1, 2);
		assertThat(tree.findBy(7).isPresent(), is(false));
	}

	@Test
	public void whenTreeIsBinary() {
		Tree<Integer> tree = new Tree<>(0);
		tree.add(0, 1);
		tree.add(0, 2);
		tree.add(1, 3);
		tree.add(1, 4);
		boolean result = tree.isBinary();
		assertTrue(result);
	}

	@Test
	public void whenTreeIsNotBinary() {
		Tree<Integer> tree = new Tree<>(0);
		tree.add(0, 1);
		tree.add(0, 2);
		tree.add(0, 3);
		tree.add(1, 3);
		tree.add(1, 4);
		boolean result = tree.isBinary();
		assertFalse(result);
	}

	@Test
	public void whenIterate() {
		Tree<Integer> tree = new Tree<>(1);
		tree.add(1, 2);
		tree.add(1, 3);
		tree.add(1, 4);
		tree.add(4, 5);

		Iterator it = tree.iterator();
		assertThat(it.next(), is(1));
		assertTrue(it.hasNext());
		assertThat(it.next(), is(2));
		assertTrue(it.hasNext());
		assertThat(it.next(), is(3));
		assertTrue(it.hasNext());
		assertThat(it.next(), is(4));
		assertTrue(it.hasNext());
		assertThat(it.next(), is(5));
		assertFalse(it.hasNext());
	}
}
