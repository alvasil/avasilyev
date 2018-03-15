package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator {
	private final int[] values;
	private int index = 0;

	public PrimeIterator(final int[] values) {
		this.values = values;
	}

	@Override
	public boolean hasNext() {
		boolean result = false;
		for (int i = index; i < this.values.length; i++) {
			if ((this.values[i] == 2 && this.values[i] % 2 == 0) || (this.values[i] > 1 && this.values[i] != 2 && this.values[i] % 2 != 0)) {
				index = i;
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public Object next() {
		if (!hasNext()) {
			throw new NoSuchElementException("no such element");
		}
		return this.values[index++];

	}
}
