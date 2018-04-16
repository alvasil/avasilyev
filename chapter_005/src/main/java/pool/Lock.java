package pool;

public class Lock {
	private boolean isLocked;

	/**
	 * Проверяет свободен ли лок.
	 * Если да - захватывает, иначе блокируется
	 */
	public void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
	}

	/**
	 * Проверяет владеет ли поток локом.
	 * Если да то - освобождает.
	 */
	public void unlock() {
		if (isLocked) {
			notifyAll();
		}
		isLocked = false;
	}
}
