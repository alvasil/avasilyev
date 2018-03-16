package ru.job4j.iterator;

import java.util.Iterator;

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
			public Integer next() {
				Integer result = current.next();
				if (it.hasNext() && !current.hasNext()) {
					current = it.next();
					return result;
				}
				return result;
			}
		};
	}

}
