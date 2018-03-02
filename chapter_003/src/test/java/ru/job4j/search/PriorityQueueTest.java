package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
	@Test
	public void whenHigherPriority() {
		PriorityQueue queue = new PriorityQueue();
		queue.put(new Task("last", 5));
		queue.put(new Task("first", 1));
		queue.put(new Task("middle", 3));
		Task result = queue.take();
		assertThat(result.getDesc(), is("first"));
	}
}
