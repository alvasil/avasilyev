package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Linked<E> implements Iterable {
	private Node<E> first;
	private Node<E> last;
	private int size = 0;
	private int modCount = 0;

	/**
	 * size == 0: создается узел,
	 * у которого предыдущий и следующий элементы отсутствуют,
	 * т.е. являются null, размер коллекции увеличивается на 1,
	 * а созданный узел устанавливается как первый и последний элемент коллекции.
	 * <p>
	 * size > 0: Сначала создается узел для нового элемента,
	 * и устанавливается ссылка на существующий элемент коллекции как на предыдущий,
	 * а следующим элементом у созданного узла остается null.
	 * Также этот новый узел сохраняется в переменную связанного списка last
	 *
	 * @param value
	 */
	public void add(E value) {
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

	public E get(int index) throws NoSuchElementException {
		Node<E> eNode = first;
		if (index > size) {
			throw new NoSuchElementException();
		}
		for (int i = 0; i < index; i++) {
			eNode = eNode.next;
		}
		return eNode.element;
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

	private class Node<E> {
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
