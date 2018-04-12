package pool;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

	@GuardedBy("this")
	private Queue<T> queue = new LinkedList<>();
	private int limit;

	public SimpleBlockingQueue(int limit) {
		this.limit = limit;
	}

	/**
	 * Producer
	 * Очередь полная - ожидание.
	 *
	 * @param value - вставляемый элемент
	 */
	public synchronized void offer(T value) {
		while (queue.size() == limit) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		System.out.printf("Thread %s , offer: %s\n", Thread.currentThread().getName(), value);
		queue.offer(value);
	}

	/**
	 * Consumer
	 * Очередь пустая - ожидание.
	 *
	 * @return - объект из внутренней коллекции.
	 */
	public synchronized T poll() {
		while (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		T polled = queue.poll();
		System.out.printf("Thread %s , polled: %s\n", Thread.currentThread().getName(), polled);
		return polled;
	}
}

