package pool;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class ThreadPool {
	private int nProcessors = Runtime.getRuntime().availableProcessors();

	@GuardedBy("this")
	private final Queue<Work> pool = new LinkedList<>();

	public synchronized void add(Work work) {
		this.pool.add(work);
		notifyAll();
	}

	/**
	 * Создает потоки в кол-ве равном кол-ву процессоров
	 * Если пул пустой - ожидание
	 */
	public void execute() {
		for (int i = 0; i < nProcessors; i++) {
			new Thread() {
				@Override
				public void run() {
					Work work;

					while (true) {
						synchronized (pool) {
							while (pool.isEmpty()) {
								try {
									pool.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							work = pool.poll();
						}
						work.doWork();
					}
				}
			};
		}
	}
}
