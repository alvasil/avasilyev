package ru.job4j.set;

import ru.job4j.list.AbstractArray;

public class SetArray<E> extends AbstractArray<E> {
	public SetArray(int size) {
		super.setContainer(new Object[size]);
	}

	@Override
	public void add(E value) {
		for (int i = 0; i < getContainer().length; i++) {
			if (value.equals(getContainer()[i])) {
				return;
			}
		}
		super.add(value);
	}
}

