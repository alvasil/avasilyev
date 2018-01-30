package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringContainsTest {
	@Test
	public void whenOriginContainSubThenTrue() {
		StringContains word = new StringContains();
		boolean result = word.contains("hello", "hell");
		assertTrue(result);
	}

	@Test
	public void whenOriginNotContainSubThenFalse() {
		StringContains word = new StringContains();
		boolean result = word.contains("hello", "qwe");
		assertFalse(result);
	}

}
