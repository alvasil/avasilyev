package ru.job4j.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleArray<T> implements Iterable<T> {
	private List<T> array;

	public SimpleArray() {
		this.array = new ArrayList<>();
	}

	public void add(T model) {
		this.array.add(model);
	}

	public void set(int index, T model) {
		this.array.add(index, model);
	}

	public void delete(int index) {
		this.array.remove(index);
	}

	public int get(int index) {
		return (Integer) array.get(index);
	}

	@Override
	public Iterator<T> iterator() {
		return this.array.iterator();
	}
}
