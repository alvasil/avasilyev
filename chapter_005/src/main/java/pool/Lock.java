package pool;

import net.jcip.annotations.GuardedBy;

public class Lock {
	@GuardedBy("this")
	private boolean isLocked;

	/**
	 * Проверяет свободен ли лок.
	 * Если да - захватывает, иначе блокируется.
	 */
	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
	}

	/**
	 * Проверяет владеет ли поток локом.
	 * Если да - освобождает.
	 */
	public synchronized void unlock() {
		if (isLocked) {
			notifyAll();
		}
		isLocked = false;
	}
}
