package ru.job4j.set;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SetLinked<E> implements Iterable<E> {
	private Node<E> first;
	private Node<E> last;
	private int size = 0;
	private int modCount = 0;

	public void add(E value) {
		if (!checkEquals(value)) {
			Node<E> newNode = new Node<>(last, value, null);
			if (last == null) {
				first = newNode;
			} else {
				last.next = newNode;
			}
			last = newNode;
			modCount++;
			size++;
		}
	}

	public boolean checkEquals(E value) {
		boolean result = false;
		Node<E> check = first;
		for (int i = 0; i < size; i++) {
			if (check.element != null && value.equals(check.element)) {
				result = true;
				break;
			}
			check = check.next;
		}
		return result;
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

	class Node<E> {
		E element;
		Node<E> prev;
		Node<E> next;

		public Node(Node<E> prev, E element, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}
}

