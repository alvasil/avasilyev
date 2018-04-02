package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
	private Node<E> root;

	public Tree(E root) {
		this.root = new Node<>(root);
	}

	@Override
	public boolean add(E parent, E child) {
		boolean result = false;
		if (this.root.eqValue(parent)) {
			if (!this.root.haveDoubles(child)) {
				this.root.add(new Node<>(child));
				result = true;
			} else {
				result = false;
			}
		} else {
			Node<E> current = this.root;
			while (!current.eqValue(parent)) {
				for (Node ch : current.getChildren()) {
					if (ch.eqValue(parent)) {
						ch.add(new Node(child));
						current.value = parent;
						result = true;
						break;
					} else {
						current = ch;
					}
				}
			}
		}
		return result;
	}


	@Override
	public Optional<Node<E>> findBy(E value) {
		Optional<Node<E>> rsl = Optional.empty();
		Queue<Node<E>> data = new LinkedList<>();
		data.offer(this.root);
		while (!data.isEmpty()) {
			Node<E> el = data.poll();
			if (el.eqValue(value)) {
				rsl = Optional.of(el);
				break;
			}
			for (Node<E> child : el.getChildren()) {
				data.offer(child);
			}
		}
		return rsl;
	}

	@Override
	public Iterator iterator() {
		return new Iterator() {
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Object next() {
				return null;
			}
		};
	}
}
