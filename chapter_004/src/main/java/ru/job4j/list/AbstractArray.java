package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public abstract class AbstractArray<E> implements Iterable {
	private Object[] container;
	public int index = 0;
	public int modCount = 0;

	public Object[] getContainer() {
		return container;
	}

	public void setContainer(Object[] container) {
		this.container = container;
	}

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
