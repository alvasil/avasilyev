package threads;

public class Wait {

	public static class Cycling implements Runnable {
		@Override
		public void run() {
			long i = -999999999;
			while (i != 999999999) {
				i++;
			}
			System.out.println(i);
			System.out.println("End program.");
		}
	}

	public static void main(String[] args) {
		Thread cycle = new Thread(new Cycling());
		System.out.println("Starting program...");
		cycle.start();
	}
}
