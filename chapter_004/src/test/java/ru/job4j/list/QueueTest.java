package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class QueueTest {
	@Test
	public void whenAddNewObjectToQueue() {
		SimpleQueue<Integer> queue = new SimpleQueue<>();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		assertThat(queue.getSize(), is(4));
		queue.poll(); // 1
		queue.poll(); // 2
		queue.poll(); // 3
		assertThat(queue.first, is(queue.last)); // 4 = 4
		assertThat(queue.getSize(), is(1));
	}
}
