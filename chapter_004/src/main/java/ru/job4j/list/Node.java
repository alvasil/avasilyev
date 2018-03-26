package ru.job4j.list;

public class Node<E> {
	public E element;
	public Node<E> prev;
	public Node<E> next;

	public Node(Node<E> prev, E element, Node<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Node<E> getPrev() {
		return prev;
	}

	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}
}


