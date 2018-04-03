package ru.job4j.tree;

public class BinaryTree<E extends Comparable<E>> {
	private BinaryTree<E> left;
	private BinaryTree<E> right;
	private E data;


	public BinaryTree(E data) {
		this.data = data;
	}

	public void add(E e) {
		if (data.compareTo(e) < 0) { //e больше data
			if (right == null) {
				right = new BinaryTree<>(e);
			} else {
				right.add(e);
			}
		} else {                    // е меньше data
			if (left == null) {
				left = new BinaryTree<>(e);
			} else {
				left.add(e);
			}
		}
	}
}
