package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
	private Object[] array;
	private int index = 0;
	private int size;

	public SimpleArray(int size) {
		this.size = size;
		this.array = new Object[size];
	}

	public void add(T model) {
		if (index < this.array.length) {
			this.array[index++] = model;
			return;
		}
		if (index >= this.array.length) {
			Object[] newContainer = Arrays.copyOf(this.array, index + 1);
			newContainer[index++] = model;
			this.array = newContainer;
		}
	}

	public void set(int index, T model) {
		this.array[index] = model;
	}

	public void delete(int index) {
		System.arraycopy(this.array, index + 1, this.array, index, size - index - 1);
		size--;
	}

	public T get(int index) {
		return (T) this.array[index];
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;

			@Override
			public boolean hasNext() {
				return i < index;
			}

			@Override
			public T next() {
				return (T) array[i++];
			}
		};
	}
}
