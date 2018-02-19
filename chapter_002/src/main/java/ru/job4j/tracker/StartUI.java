package ru.job4j.tracker;

public class StartUI {
	/**
	 * Константы меню.
	 */
	private static final String ADD = "0";
	private static final String SHOW = "1";
	private static final String EDIT = "2";
	private static final String DELETE = "3";
	private static final String FINDBYID = "4";
	private static final String FINDBYNAME = "5";
	private static final String EXIT = "6";
	/**
	 * Получение данных от пользователя.
	 */
	private final Input input;

	/**
	 * Хранилище заявок.
	 */
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
		boolean exit = false;
		while (!exit) {
			this.showMenu();
			String answer = this.input.ask("Введите пункт меню : ");
			if (ADD.equals(answer)) {
				this.createItem();
			} else if (SHOW.equals(answer)) {
				this.showItems();
			} else if (EDIT.equals(answer)) {
				this.editItem();
			} else if (DELETE.equals(answer)) {
				this.deleteItem();
			} else if (FINDBYID.equals(answer)) {
				this.findByIdItem();
			} else if (FINDBYNAME.equals(answer)) {
				this.findByNameItem();
			} else if (EXIT.equals(answer)) {
				exit = true;
				System.out.println("Завершение программы...");
			}
		}
	}

	/**
	 * Метод реализует добавление новый заявки в хранилище.
	 */
	private void createItem() {
		System.out.println("--- Добавление новой языки ---");
		String name = this.input.ask("Введите имя заявки :");
		String desc = this.input.ask("Введите описание заявки :");
		Item item = new Item(name, desc);
		this.tracker.add(item);
		System.out.println("Новая заявка: имя - " + item.getName() + " | описание - " + item.getDesc() + " | id - " + item.getId() + " |");
	}

	/**
	 * метод показывает список заявок
	 */
	private void showItems() {
		System.out.println("--- Все имеющиеся заявки ---");
		System.out.println("В хранилище количество заявок: " + this.tracker.findAll().length);
		for (int i = 0; i != this.tracker.findAll().length; i++) {
			System.out.println(this.tracker.findAll()[i].getName() + " " + this.tracker.findAll()[i].getDesc() + " " + this.tracker.findAll()[i].getId());
		}
	}

	/**
	 * метод позволяет редактировать заявку
	 */
	private void editItem() {
		System.out.println("--- Редактирование заявки ---");
		String id = this.input.ask("Введите id заявки из которой хотите взять данные: ");
		String idReplace = this.input.ask("Введите id заявки в которой хотите заменить данные: ");
		Item item = new Item(null, null, idReplace);
		tracker.replace(id, item);
		System.out.println("Заявка с id: " + item.getId() + " имеет новое имя " + item.getName());
	}

	/**
	 * метод удаляет заявку
	 */
	private void deleteItem() {
		System.out.println("--- Удаление заявки ---");
		String id = this.input.ask("Введите id заявки : ");
		tracker.delete(id);
		Item item = new Item(id);
		System.out.println("Заявка с id: " + item.getId() + " - удалена");
		System.out.println("Заявок в трекере: " + tracker.findAll().length);
	}

	/**
	 * метод ищет заявку по id
	 */
	private void findByIdItem() {
		System.out.println("--- Поиск заявки по id ---");
		String id = this.input.ask("Введите id заявки : ");
		System.out.println("Заявка с данным id: " + tracker.findById(id).getName());
	}

	/**
	 * метод ищет заявку по имени
	 */
	private void findByNameItem() {
		System.out.println("--- Поиск заявок по имени ---");
		String name = this.input.ask("Введите имя заявки : ");
		for (int i = 0; i != this.tracker.findAll().length; i++) {
			System.out.println("Заявка с данным именем имеет id: " + this.tracker.findByName(name)[i].getId() + " и описание: " + this.tracker.findByName(name)[i].getDesc());
		}
	}

	private void showMenu() {
		System.out.println("--- Меню ---");
		System.out.println("0. Add new Item");
		System.out.println("1. Show all items");
		System.out.println("2. Edit item");
		System.out.println("3. Delete item");
		System.out.println("4. Find item by Id");
		System.out.println("5. Find items by name");
		System.out.println("6. Exit Program");
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