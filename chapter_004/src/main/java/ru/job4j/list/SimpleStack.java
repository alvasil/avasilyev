package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> extends AbstractLinked<T> {

	/**
	 * метод удаляет последний элемент в списке: LIFO
	 *
	 * @return - последний элемент в списке (удаляется)
	 */
	public T poll() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node<T> newLast = getFirst();
		Node<T> polled = getLast();
		if (size > 1) {
			for (int i = 0; i < size - 2; i++) {
				newLast = newLast.next;
			}
		}
		setLast(newLast);
		size--;
		return polled.element;
	}

	/**
	 * метод помещает объект в конец списка
	 *
	 * @param value - помещаемый элемент
	 */
	public void push(T value) {
		super.add(value);
		getLast().prev = null;
	}
}

