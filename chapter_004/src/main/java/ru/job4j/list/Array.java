package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Array<E> implements SimpleContainer<E> {
	private Object[] container;
	private int index = 0;
	private int modCount = 0;

	public Array(int size) {
		this.container = new Object[size];
	}

	@Override
	public void add(E value) {
		if (index < this.container.length) {
			this.container[index++] = value;
			this.modCount++;
			return;
		}
		if (index >= this.container.length) {
			Object[] newContainer = Arrays.copyOf(this.container, index + 1);
			newContainer[index++] = value;
			this.container = newContainer;
			this.modCount++;
		}
	}

	@Override
	public E get(int index) {
		return (E) this.container[index];
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
