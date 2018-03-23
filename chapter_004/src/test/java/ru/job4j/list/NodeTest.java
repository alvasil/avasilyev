package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeTest {
	@Test
	public void whenCycled() {
		Node one = new Node<>(1);
		Node two = new Node<>(2);
		Node three = new Node<>(3);
		Node four = new Node<>(4);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = one;
		assertTrue(one.hasCycle(one));
	}

	@Test
	public void whenNotCycled() {
		Node one = new Node<>(1);
		Node two = new Node<>(2);
		Node three = new Node<>(3);
		Node four = new Node<>(4);
		one.next = two;
		two.next = three;
		three.next = four;
		assertFalse(one.hasCycle(one));
	}

	@Test
	public void whenCycledInMid() {
		Node one = new Node<>(1);
		Node two = new Node<>(2);
		Node three = new Node<>(3);
		Node four = new Node<>(4);
		one.next = two;
		two.next = three;
		three.next = two;
		assertTrue(one.hasCycle(two));
	}
}
