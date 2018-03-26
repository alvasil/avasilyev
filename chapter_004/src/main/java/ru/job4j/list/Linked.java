package ru.job4j.list;

import java.util.NoSuchElementException;

public class Linked<E> extends AbstractLinked<E> implements Iterable {
	public E get(int index) throws NoSuchElementException {
		Node<E> eNode = super.getFirst();
		if (index > super.getSize()) {
			throw new NoSuchElementException();
		}
		for (int i = 0; i < index; i++) {
			eNode = eNode.getNext();
		}
		return eNode.getElement();
	}
}
