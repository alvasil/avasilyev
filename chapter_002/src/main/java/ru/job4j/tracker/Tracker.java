package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
	private final Item[] items = new Item[100];
	private int position = 0;
	private static final Random RN = new Random();

	/**
	 * Метод реализаущий добавление заявки в хранилище
	 *
	 * @param item новая заявка
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[this.position++] = item;
		return item;
	}
	/**
	 * Метод генерирует уникальный ключ для заявки.
	 *
	 * @return Уникальный ключ.
	 */
	String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
	/**
	 * редактирование заявок
	 * должен заменить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по id
	 *
	 * @param id
	 * @param item
	 */
	public void replace(String id, Item item) {
		for (int index = 0; index != this.position; index++) {
			if (this.items[index].getId().equals(id)) {
				item.setName(this.items[index].getName());
			}
		}
	}
	/**
	 * удаление заявок
	 *
	 * @param id
	 */
	public void delete(String id) {
		for (int index = 0; index != this.position; index++) {
			if (this.items[index].getId().equals(id)) {
				System.arraycopy(this.items, 0, this.items, index, this.position - 1);
			}
		}
	}
	/**
	 * получение списка всех заявок
	 *
	 * @return список заявок
	 */
	public Item[] findAll() {
		Item[] result = new Item[this.position];
		for (int index = 0; index != this.position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}
	/**
	 * получение списка по имени
	 *
	 * @param key
	 * @return
	 */
	public Item[] findByName(String key) {
		Item[] result = new Item[this.position - 1];
		for (int index = 0; index != this.position; index++) {
			if (this.items[index].getName().equals(key)) {
				result[index] = this.items[index];
				break;
			}
		}
		return result;
	}
	/**
	 * получение заявки по id
	 *
	 * @param id
	 * @return
	 */
	public Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
}

