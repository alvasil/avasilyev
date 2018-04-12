package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

@ThreadSafe
public abstract class AbstractLinked<E> implements Iterable {
	@GuardedBy("this")
	private Node<E> first;

	@GuardedBy("this")
	private Node<E> last;

	@GuardedBy("this")
	public int size = 0;

	@GuardedBy("this")
	private int modCount = 0;

	public synchronized Node<E> getFirst() {
		return first;
	}

	public synchronized void setFirst(Node<E> first) {
		this.first = first;
	}

	public synchronized Node<E> getLast() {
		return last;
	}

	public synchronized void setLast(Node<E> last) {
		this.last = last;
	}

	public synchronized int getSize() {
		return size;
	}

	public synchronized void add(E value) {
		Node<E> newNode = new Node<>(last, value, null);
		if (newNode.getPrev() == null) {
			this.first = newNode;
		} else {
			this.last.next = newNode;
		}
		this.last = newNode;
		this.modCount++;
		this.size++;
	}

	@Override
	public synchronized Iterator iterator() {
		return new Iterator() {
			private Node<E> current;
			int expectedModCount = modCount;
			int nextCount = 0;

			@Override
			public boolean hasNext() {
				checkForModification();
				return (current != null && current.next != null);
			}

			@Override
			public synchronized E next() {
				checkForModification();
				if (nextCount == 0) {
					current = first;
					nextCount++;
				} else {
					current = current.next;
				}
				return current.element;
			}

			final synchronized void checkForModification() {
				if (modCount != expectedModCount) {
					throw new ConcurrentModificationException();
				}
			}
		};
	}
}
