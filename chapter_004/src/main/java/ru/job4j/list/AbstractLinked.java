package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public abstract class AbstractLinked<E> implements Iterable {
	private Node<E> first;
	private Node<E> last;
	public int size = 0;
	private int modCount = 0;

	public Node<E> getFirst() {
		return first;
	}

	public void setFirst(Node<E> first) {
		this.first = first;
	}

	public Node<E> getLast() {
		return last;
	}

	public void setLast(Node<E> last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void add(E value) {
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
	public Iterator iterator() {
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
			public E next() {
				checkForModification();
				if (nextCount == 0) {
					current = first;
					nextCount++;
				} else {
					current = current.next;
				}
				return current.element;
			}

			final void checkForModification() {
				if (modCount != expectedModCount) {
					throw new ConcurrentModificationException();
				}
			}
		};
	}
}
