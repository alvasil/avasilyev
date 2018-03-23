package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StackTest {
	@Test
	public void whenAddNewObjectToStack() {
		SimpleStack<Integer> stack = new SimpleStack<>();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		stack.push(44);
		assertThat(stack.getSize(), is(4));
		stack.poll();
		stack.poll();
		stack.poll();
		assertThat(stack.last, is(stack.first)); // 11 = 11
		assertThat(stack.getSize(), is(1));
	}
}
