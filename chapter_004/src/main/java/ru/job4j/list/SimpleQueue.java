package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleQueue<T> extends AbstractLinked<T> {

	/**
	 * метод удаляет первый элемент в списке: FIFO
	 *
	 * @return - первый элемент в списке (удаляется)
	 */

	public T poll() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node<T> polled = getFirst();
		setFirst(getFirst().next);
		super.size--;
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
