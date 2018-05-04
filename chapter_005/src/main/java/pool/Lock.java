package pool;

import net.jcip.annotations.GuardedBy;

public class Lock {
	@GuardedBy("this")
	private boolean isLocked;

	private Thread owner;

	/**
	 * Проверяет свободен ли лок.
	 * Если да - захватывает, иначе блокируется.
	 */
	public synchronized void lock() throws InterruptedException {
		Thread current = Thread.currentThread();
		while (isLocked) {
			wait();
		}
		isLocked = true;
		owner = current;
	}

	/**
	 * Проверяет владеет ли поток локом.
	 * Если да - освобождает.
	 */
	public synchronized void unlock() {
		if (isLocked && owner == Thread.currentThread()) {
			notifyAll();
		}
		isLocked = false;
	}
}
