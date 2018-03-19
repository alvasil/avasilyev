package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Array implements SimpleContainer {
	private Object[] container;
	private int index = 0;
	private int modCount = 0;

	public Array(int size) {
		this.container = new Object[size];
	}

	@Override
	public void add(Object o) {
		if (index < this.container.length) {
			this.container[index++] = o;
			this.modCount++;
			return;
		}
		if (index >= this.container.length) {
			Object[] newContainer = Arrays.copyOf(this.container, index + 1);
			newContainer[index++] = o;
			this.container = newContainer;
			this.modCount++;
		}
	}

	@Override
	public Object get(int index) {
		return this.container[index];
	}

	@Override
	public Iterator iterator() {

		return new Iterator() {
			int expectedModCount = modCount;
			int i = 0;

			@Override
			public boolean hasNext() {
				boolean result = false;
				checkForModification();
				if (container[i + 1] != null) {
					result = true;
				}
				return result;
			}

			@Override
			public Object next() {
				checkForModification();
				return container[i++];
			}

			final void checkForModification() {
				if (modCount != expectedModCount) {
					throw new ConcurrentModificationException();
				}
			}
		};
	}
}
