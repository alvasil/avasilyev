package threads;

/**
 * данный класс демонстрирует проблему многопоточности:
 * создаем 100 потоков, при этом в каждом инкременируем переменную 10 раз;
 * ожидаемый результат = 1000, однако в итоге выполнения прогрыммы он всегда разный;
 */
public class Trouble {
	public static void main(String[] args) {
		Index index = new Index();
		for (int i = 0; i < 100; i++) {
			new Thread() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						index.increase();
					}
				}
			}.start();
		}
		System.out.println(index.getIndex());
	}
}

