package ru.job4j.tracker;

public class StartUI {

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
			int key = Integer.valueOf(input.ask("Select: "));
			menu.select(key);
		} while (!"y".equals(input.ask("Exit?(y):")));

	}

	/**
	 * Запускт программы.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		new StartUI(new ConsoleInput(), new Tracker()).init();
	}
}