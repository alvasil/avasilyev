package ru.job4j.set;

import ru.job4j.list.AbstractLinked;
import ru.job4j.list.Node;

public class SetLinked<E> extends AbstractLinked<E> implements Iterable {

	@Override
	public void add(E value) {
		if (!checkEquals(value)) {
			super.add(value);
		}
	}

	public boolean checkEquals(E value) {
		boolean result = false;
		Node<E> check = getFirst();
		for (int i = 0; i < getSize(); i++) {
			if (check.getElement() != null && value.equals(check.getElement())) {
				result = true;
				break;
			}
			check = check.getNext();
		}
		return result;
	}
}

