package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
	private Node<E> root;
	private int count;

	public Tree(E root) {
		this.root = new Node<>(root);
	}

	/**
	 * Проверяет количество дочерних элементов в дереве.
	 *
	 * @return - {@code true}, если дочек <= 2.
	 */
	public boolean isBinary() {
		boolean result = false;
		Node<E> current = this.root;
		if (current.getChildren().size() <= 2) {
			while (current.getChildren().size() > 0) {
				for (Node<E> e : current.getChildren()) {
					result = (e.getChildren().size() <= 2);
					current = e;
					break;
				}
			}
		}
		return result;
	}

	@Override
	public boolean add(E parent, E child) {
		boolean result = false;
		if (findBy(parent).isPresent() && !findBy(child).isPresent()) {
			Node<E> current = findBy(parent).orElse(new Node<>(parent));
			current.add(new Node<>(child));
			count++;
			result = true;
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
			Queue<Node<E>> queue = new ArrayDeque<>();
			Node<E> current = root;
			int itCount;

			/**
			 * анонимный инициализатор
			 */ {
				if (current == root) {
					queue.offer(root);
				}
				for (Node<E> ch : current.getChildren()) {
					queue.offer(ch);
					current = ch;
				}
				for (Node<E> ch : current.getChildren()) {
					queue.offer(ch);
				}
			}


			@Override
			public boolean hasNext() {
				return count >= itCount;
			}

			@Override
			public Object next() {
				itCount++;
				return queue.poll().value;
			}
		};
	}
}
