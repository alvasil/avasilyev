package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * внешний внутренний класс для выхода из программы
 */
class Exit extends BaseAction {
	public Exit(int key, String name) {
		super(key, name);
	}

	public void execute(Input input, Tracker tracker) {
	}
}

public class MenuTracker {
	private Input input;
	private Tracker tracker;
	private List<UserAction> actions = new ArrayList<>();

	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	public void fillActions() {
		this.actions.add(new AddItem(0, "Add Item"));
		this.actions.add(new MenuTracker.ShowItems(1, "Show all items"));
		this.actions.add(new EditItem(2, "Edit Item"));
		this.actions.add(new DeleteItem(3, "Delete item"));
		this.actions.add(new FindByIdItem(4, "Find item by id"));
		this.actions.add(new FindByNameItem(5, "Find item by name"));
		this.actions.add(new Exit(6, "Exit program"));
	}

	public void select(int key) {
		this.actions.get(key).execute(this.input, this.tracker);
	}

	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}

	/**
	 * [0] - внутренний класс для добавления заявки
	 */
	public class AddItem extends BaseAction {
		public AddItem(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Введите имя заявки: ");
			String desc = input.ask("Введите описание заявки: ");
			tracker.add(new Item(name, desc));
		}
	}

	/**
	 * [1] - внутренний статический класс для показа всех добавленных заявок
	 */
	public static class ShowItems extends BaseAction {
		public ShowItems(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			for (Item item : tracker.findAll()) {
				System.out.println(String.format("%s | %s | %s |", item.getName(), item.getDesc(), item.getId()));
			}
		}
	}

	/**
	 * [2] - внутренний класс для редактирования заявки
	 */
	public class EditItem extends BaseAction {
		public EditItem(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Введите id заявки: ");
			String name = input.ask("Введите новое имя заявки: ");
			String desc = input.ask("Введите новое описание заявки: ");
			tracker.replace(id, new Item(name, desc, id));
		}
	}

	/**
	 * [3] - внутренний класс для удаления заявки
	 */
	public class DeleteItem extends BaseAction {
		public DeleteItem(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Введите id заявки: ");
			tracker.delete(id);
			System.out.println(String.format("Заявка с id %s удалена", id));
		}
	}

	/**
	 * [4] - внутренний класс для поиска заявки по id
	 */
	public class FindByIdItem extends BaseAction {
		public FindByIdItem(int key, String name) {
			super(key, name);
		}

		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Введите id заявки: ");
			System.out.println(String.format("Заявка с id: %s", tracker.findById(id).getName()));
		}
	}

	/**
	 * [5] - внутренний класс для поиска заявки по name
	 */
	public class FindByNameItem extends BaseAction {
		public FindByNameItem(int key, String name) {
			super(key, name);
		}

		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Введите имя заявки: ");
			for (Item item : tracker.findByName(name)) {
				if (item != null) {
					System.out.println("Заявка с именем: " + item.getId());
					break;
				}
			}
		}
	}
}