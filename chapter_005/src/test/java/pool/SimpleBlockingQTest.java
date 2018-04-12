package pool;

import org.junit.Test;

public class SimpleBlockingQTest {
	@Test
	public void whenAddToQValuesOverLimitThenBlockQ() throws InterruptedException {
		SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);

		Thread producer = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					queue.offer(i);
				}
			}
		};

		Thread consumer = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					queue.poll();
				}
			}
		};

		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
	}
}
