package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

class Node<E extends Comparable<E>> {
	private final List<Node<E>> children = new ArrayList<>();
	public E value;

	public Node(final E value) {
		this.value = value;
	}

	/**
	 *
	 * @param child
	 * @return - true если уже есть такой элемент
	 */

	public boolean haveDoubles(E child) {
		boolean result = false;
		for (Node e : this.children) {
			if (e.eqValue(child)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public void add(Node<E> child) {
		this.children.add(child);
	}

	public boolean eqValue(E that) {
		return this.value.compareTo(that) == 0;
	}

	public List<Node<E>> getChildren() {
		return children;
	}

	public E getValue() {
		return value;
	}

}
