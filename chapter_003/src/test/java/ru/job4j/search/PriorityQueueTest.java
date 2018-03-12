package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
	@Test
	public void whenHigherPriority() {
		Task t1 = new Task("1", 1);
		Task t2 = new Task("2", 2);
		Task t3 = new Task("3", 3);
		Task t4 = new Task("4", 4);
		Task t5 = new Task("5", 5);
		PriorityQueue queue = new PriorityQueue();
		queue.put(t2);
		queue.put(t5);
		queue.put(t4);
		queue.put(t1);
		queue.put(t3);
		assertThat(queue.take(), is(t1));
		assertThat(queue.take(), is(t2));
		assertThat(queue.take(), is(t3));
		assertThat(queue.take(), is(t4));
		assertThat(queue.take(), is(t5));
	}
}
