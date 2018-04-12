package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

@ThreadSafe
public abstract class AbstractArray<E> implements Iterable {
	@GuardedBy("this")
	private Object[] container;

	@GuardedBy("this")
	public int index = 0;

	@GuardedBy("this")
	public int modCount = 0;

	public synchronized Object[] getContainer() {
		return container;
	}

	public synchronized void setContainer(Object[] container) {
		this.container = container;
	}

	public synchronized void add(E value) {
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
	public synchronized Iterator iterator() {
		return new Iterator() {
			int expectedModCount = modCount;
			int i = 0;

			@Override
			public synchronized boolean hasNext() {
				boolean result = false;
				checkForModification();
				if (container[i + 1] != null) {
					result = true;
				}
				return result;
			}

			@Override
			public synchronized Object next() {
				checkForModification();
				return container[i++];
			}

			final synchronized void checkForModification() {
				if (modCount != expectedModCount) {
					throw new ConcurrentModificationException();
				}
			}
		};
	}
}
