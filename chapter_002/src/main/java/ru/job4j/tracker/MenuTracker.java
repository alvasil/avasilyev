package ru.job4j.tracker;

/**
 * внешний внутренний класс для выхода из программы
 */
class Exit implements UserAction {
	public int key() {
		return 6;
	}

	public void execute(Input input, Tracker tracker) {

	}

	public String info() {
		return String.format("%s. %s", this.key(), "Exit Program.");
	}

}

public class MenuTracker {
	private Input input;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[7];

	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	public void fillActions() {
		this.actions[0] = new AddItem();
		this.actions[1] = new MenuTracker.ShowItems();
		this.actions[2] = new EditItem();
		this.actions[3] = new DeleteItem();
		this.actions[4] = new FindByIdItem();
		this.actions[5] = new FindByNameItem();
		this.actions[6] = new Exit();
	}

	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
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
	public class AddItem implements UserAction {
		public int key() {
			return 0;
		}

		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Введите имя заявки: ");
			String desc = input.ask("Введите описание заявки: ");
			tracker.add(new Item(name, desc));
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Add the new item.");
		}
	}

	/**
	 * [1] - внутренний статический класс для показа всех добавленных заявок
	 */
	public static class ShowItems implements UserAction {
		public int key() {
			return 1;
		}

		public void execute(Input input, Tracker tracker) {
			for (Item item : tracker.findAll()) {
				System.out.println(String.format("%s | %s | %s |", item.getName(), item.getDesc(), item.getId()));
			}
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Show all items.");
		}
	}

	/**
	 * [2] - внутренний класс для редактирования заявки
	 */
	public class EditItem implements UserAction {
		public int key() {
			return 2;
		}

		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Введите id заявки: ");
			String name = input.ask("Введите новое имя заявки: ");
			String desc = input.ask("Введите новое описание заявки: ");
			tracker.replace(id, new Item(name, desc, id));
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Edit item.");
		}
	}

	/**
	 * [3] - внутренний класс для удаления заявки
	 */
	public class DeleteItem implements UserAction {
		public int key() {
			return 3;
		}

		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Введите id заявки: ");
			tracker.delete(id);
			System.out.println(String.format("Заявка с id %s удалена", id));
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Delete item.");
		}
	}

	/**
	 * [4] - внутренний класс для поиска заявки по id
	 */
	public class FindByIdItem implements UserAction {
		public int key() {
			return 4;
		}

		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Введите id заявки: ");
			System.out.println(String.format("Заявка с id: %s", tracker.findById(id).getName()));
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Find item by id.");
		}
	}

	/**
	 * [5] - внутренний класс для поиска заявки по name
	 */
	public class FindByNameItem implements UserAction {
		public int key() {
			return 5;
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

		public String info() {
			return String.format("%s. %s", this.key(), "Find item by name.");
		}
	}

}
