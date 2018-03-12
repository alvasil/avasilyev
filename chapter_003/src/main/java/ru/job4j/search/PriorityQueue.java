package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
	private LinkedList<Task> tasks = new LinkedList<>();

	public void put(Task task) {
		if (this.tasks.size() == 0) {
			this.tasks.addFirst(task);
		} else if (task != null && task.getPriority() < this.tasks.getFirst().getPriority()) {
			this.tasks.addFirst(task);
		} else if (this.tasks.size() == 1) {
			if (task != null && task.getPriority() < this.tasks.getFirst().getPriority()) {
				this.tasks.addFirst(task);
			} else {
				this.tasks.addLast(task);
			}
		} else if (this.tasks.size() > 1) {
			for (int i = 0; i < this.tasks.size(); i++) {
				if (task != null && task.getPriority() > this.tasks.get(i).getPriority() && task.getPriority() < this.tasks.get(i + 1).getPriority()) {
					this.tasks.add(i + 1, task);
					break;
				}
			}
		}
	}

	public Task take() {
		return this.tasks.poll();
	}
}

