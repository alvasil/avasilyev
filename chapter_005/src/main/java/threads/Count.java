package threads;

public class Count {
	public static void main(String[] args) {
		String text = "I will be back";
		char[] arrayText = text.toCharArray();
		char space = ' ';
		System.out.printf("TEXT: %s\n", text);

		new Thread() {
			@Override
			public void run() {
				int count = 0;
				for (int i = 0; i < arrayText.length; i++) {
					if (arrayText[i] == space) {
						count++;
					}
				}
				System.out.printf("Spaces in text: %s\n", count);
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				int count = 0;
				for (int i = 0; i < arrayText.length; i++) {
					if (arrayText[i] == space) {
						count++;
					}
				}
				System.out.printf("Words in text: %s", count + 1);
			}
		}.start();
	}
}
