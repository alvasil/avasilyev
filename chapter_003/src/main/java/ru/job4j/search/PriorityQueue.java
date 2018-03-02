package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
	private LinkedList<Task> tasks = new LinkedList<>();


	public void put(Task task) {
		if (this.tasks.size() == 0) {
			this.tasks.add(task);
		} else if (this.tasks.size() >= 1) {
			if (task != null && task.getPriority() < this.tasks.getFirst().getPriority()) {
				this.tasks.addFirst(task);
			} else {
				this.tasks.addLast(task);
			}
		}
	}

	public Task take() {
		return this.tasks.poll();
	}
}

