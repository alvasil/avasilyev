package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
	@Test
	public void whenHigherPriority() {
		PriorityQueue queue = new PriorityQueue();
		queue.put(new Task("last", 10));
		queue.put(new Task("first", 2));
		queue.put(new Task("third", 5));
		queue.put(new Task("fourth", 8));
		queue.put(new Task("second", 3));
		Task result = queue.take();
		assertThat(result.getDesc(), is("first"));
	}
}
