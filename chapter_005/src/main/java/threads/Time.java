package threads;

public class Time implements Runnable {
	private long setTime;

	public Time(long setTime) {
		this.setTime = setTime;
	}

	@Override
	public void run() {
		Thread count = new Thread(new CountChar("Try to count this text"));
		long startTime = System.currentTimeMillis();
		count.start();
		if (System.currentTimeMillis() - startTime > setTime) {
			count.interrupt();
		}
	}

	/**
	 * нить считает количество символов в тексте
	 */
	public class CountChar implements Runnable {
		String text;
		int count = 0;

		public CountChar(String text) {
			this.text = text;
		}

		@Override
		public void run() {
			for (char i : text.toCharArray()) {
				if (!Thread.currentThread().isInterrupted()) {
					count++;
				} else {
					return;
				}
			}
			System.out.println(text);
			System.out.printf("Number of symbols with spaces: %d\n", count);

		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new Time(100));
		thread.start();
	}
}


