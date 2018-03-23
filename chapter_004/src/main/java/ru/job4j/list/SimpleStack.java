package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
	private int size = 0;
	public StackObject<T> first;
	public StackObject<T> last;

	/**
	 * метод удаляет последний элемент в списке: LIFO
	 *
	 * @param T - тип элемента
	 * @return - последний элемент в списке (удаляется)
	 */
	public T poll() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		StackObject<T> newLast = first;
		StackObject<T> polled = last;
		if (size > 1) {
			for (int i = 0; i < size - 2; i++) {
				newLast = newLast.next;
			}
		}
		last = newLast;
		size--;
		return polled.element;
	}

	/**
	 * метод помещает объект в конец списка
	 *
	 * @param value - помещаемый элемент
	 */
	public void push(T value) {
		StackObject<T> newValue = new StackObject<>(value, null);
		if (size == 0) {
			first = newValue;
		} else {
			last.next = newValue;
		}
		last = newValue;
		size++;
	}

	public int getSize() {
		return size;
	}

	private class StackObject<T> {
		T element;
		StackObject<T> next;

		public StackObject(T element, StackObject<T> next) {
			this.element = element;
			this.next = next;
		}
	}
}

