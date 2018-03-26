package ru.job4j.list;

public class NodeCycle<T> {
	T value;
	NodeCycle<T> next;

	public NodeCycle(T value) {
		this.value = value;
	}


	boolean hasCycle(NodeCycle first) {
		boolean result = false;
		NodeCycle test = first;
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

