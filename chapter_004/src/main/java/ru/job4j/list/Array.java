package ru.job4j.list;

public class Array<E> extends AbstractArray<E> {
	public Array(int size) {
		super.setContainer(new Object[size]);
	}

	public E get(int index) {
		return (E) getContainer()[index];
	}
}
