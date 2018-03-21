package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

	Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
		return new Iterator<Integer>() {
			Iterator<Integer> current = it.next();

			@Override
			public boolean hasNext() {
				boolean result = false;
				if (current.hasNext()) {
					result = true;
				} else {
					if (it.hasNext()) {
						current = it.next();
						if (current.hasNext()) {
							result = true;
						}
					}
				}
				return result;
			}

			@Override
			public Integer next() throws NoSuchElementException {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return current.next();
			}
		};
	}

}
