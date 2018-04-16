package pool;

public class Work {
	private int number;

	public Work(int number) {
		this.number = number;
	}

	public void doWork() {
		System.out.printf("Thread: %d\n", number);
	}
}
