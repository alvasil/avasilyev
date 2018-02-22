package ru.job4j.tracker;

public class StartUI {
	private int[] keysRange = new int[]{0, 1, 2, 3, 4, 5, 6};
	// Получение данных от пользователя.
	private final Input input;

	//Хранилище заявок.
	private final Tracker tracker;

	/**
	 * Конструтор инициализирующий поля.
	 *
	 * @param input   ввод данных.
	 * @param tracker хранилище заявок.
	 */
	public StartUI(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**
	 * Основой цикл программы.
	 */
	public void init() {
		MenuTracker menu = new MenuTracker(this.input, this.tracker);
		menu.fillActions();
		do {
			menu.show();
			menu.select(input.ask("select: ", keysRange));
		} while (!"y".equals(input.ask("Exit?(y):")));

	}

	/**
	 * Запускт программы.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		new StartUI(new ValidateInput(), new Tracker()).init();
	}
}