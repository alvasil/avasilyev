package ru.job4j.tree;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<E extends Comparable<E>> implements Iterable {
	private BNode<E> root;

	public void add(E value) {
		BNode<E> nodeToAdd = new BNode<>(value);
		if (root == null) {
			root = nodeToAdd;
		}
		traverse(root, nodeToAdd);
	}

	private void traverse(BNode<E> node, BNode<E> noteToAdd) {
		if (noteToAdd.value.compareTo(node.value) < 0) {
			if (node.left == null) {
				node.left = noteToAdd;
			} else {
				traverse(node.left, noteToAdd);
			}
		} else {
			if (noteToAdd.value.compareTo(node.value) > 0) {
				if (node.right == null) {
					node.right = noteToAdd;
				} else {
					traverse(node.right, noteToAdd);
				}
			}
		}
	}

	@Override
	public Iterator iterator() {
		return new Iterator() {
			BNode<E> current = root;
			Stack<BNode<E>> stack = new Stack<>();

			@Override
			public boolean hasNext() {
				return (!stack.isEmpty() || current != null);
			}

			@Override
			public E next() {
				while (current != null) {
					stack.push(current);
					current = current.left;
				}
				current = stack.pop();
				BNode<E> node = current;
				current = current.right;
				return node.value;

			}
		};
	}
}
