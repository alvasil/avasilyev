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
		}
	}

	public static void main(String[] args) {
		System.out.println("Information about program");
		Thread cycle = new Thread(new Cycling());
		cycle.start();
		System.out.println("End program");
	}
}
