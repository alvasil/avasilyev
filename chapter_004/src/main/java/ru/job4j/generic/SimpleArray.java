package ru.job4j.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleArray<T> implements Iterable<T> {
	List<T> list = new ArrayList<>();

	public void add(T model) {
		this.list.add(model);
	}

	public void set(int index, T model) {
		this.list.add(index, model);
	}

	public void delete(int index) {
		this.list.remove(index);
	}

	public int get(int index) {
		return (Integer) list.get(index);
	}

	@Override
	public Iterator<T> iterator() {
		return this.list.iterator();
	}
}
