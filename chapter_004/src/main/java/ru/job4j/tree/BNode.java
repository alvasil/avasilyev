package ru.job4j.tree;

public class BNode<E> {
	E value;
	BNode<E> left;
	BNode<E> right;

	public BNode(E value) {
		this.value = value;
	}
}
