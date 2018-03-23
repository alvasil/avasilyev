package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
	private int size = 0;
	public QueueObject<T> first;
	public QueueObject<T> last;

	/**
	 * метод удаляет первый элемент в списке: FIFO
	 *
	 * @param T - тип элемента
	 * @return - первый элемент в списке (удаляется)
	 */
	public T poll() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		QueueObject<T> polled = first;
		first = first.next;
		size--;
		return polled.element;
	}

	/**
	 * метод помещает объект в конец списка
	 *
	 * @param value - помещаемый элемент
	 */
	public void push(T value) {
		QueueObject<T> newValue = new QueueObject<>(value, null);
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

	private class QueueObject<T> {
		T element;
		QueueObject<T> next;

		public QueueObject(T element, QueueObject<T> next) {
			this.element = element;
			this.next = next;
		}
	}
}
