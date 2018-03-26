package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeCycleTest {
	@Test
	public void whenCycled() {
		NodeCycle one = new NodeCycle<>(1);
		NodeCycle two = new NodeCycle<>(2);
		NodeCycle three = new NodeCycle<>(3);
		NodeCycle four = new NodeCycle<>(4);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = one;
		assertTrue(one.hasCycle(one));
	}

	@Test
	public void whenNotCycled() {
		NodeCycle one = new NodeCycle<>(1);
		NodeCycle two = new NodeCycle<>(2);
		NodeCycle three = new NodeCycle<>(3);
		NodeCycle four = new NodeCycle<>(4);
		one.next = two;
		two.next = three;
		three.next = four;
		assertFalse(one.hasCycle(one));
	}

	@Test
	public void whenCycledInMid() {
		NodeCycle one = new NodeCycle<>(1);
		NodeCycle two = new NodeCycle<>(2);
		NodeCycle three = new NodeCycle<>(3);
		NodeCycle four = new NodeCycle<>(4);
		one.next = two;
		two.next = three;
		three.next = two;
		assertTrue(one.hasCycle(two));
	}
}
