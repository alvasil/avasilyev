package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
	private final int[] values;
	private int index = 0;

	public EvenIterator(final int[] values) {
		this.values = values;
	}

	@Override
	public boolean hasNext() {
		boolean result = false;
		for (int i = index; i < this.values.length; i++) {
			if (this.values[i] % 2 == 0) {
				index = i;
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public Object next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException("no such element");
		}
		return this.values[index++];

	}
}

