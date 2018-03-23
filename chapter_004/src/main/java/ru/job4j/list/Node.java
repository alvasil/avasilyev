package ru.job4j.list;

public class Node<T> {
	T value;
	Node<T> next;

	public Node(T value) {
		this.value = value;
	}


	boolean hasCycle(Node first) {
		boolean result = false;
		Node test = first;
		while (test.next != first) {
			test = test.next;
			result = true;
			if (test.next == null) {
				result = false;
				break;
			}
		}
		return result;
	}
}

