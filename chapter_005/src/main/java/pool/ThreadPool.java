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

	private WorkThread[] threads;

	public ThreadPool() {
		this.threads = new WorkThread[nProcessors];
		for (int i = 0; i < nProcessors; i++) {
			threads[i] = new WorkThread();
			threads[i].start();
		}
	}

	public synchronized void add(Work work) {
		this.pool.add(work);
		notifyAll();
	}

	public class WorkThread extends Thread {
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
	}
}
