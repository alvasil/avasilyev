package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
	private List<Item> items = new ArrayList<>();
	private static final Random RN = new Random();

	/**
	 * Метод реализаущий добавление заявки в хранилище
	 *
	 * @param item новая заявка
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items.add(item);
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
	 * @param id   - уникальный ключ заявки
	 * @param item - заявка в коллекции
	 */
	public void replace(String id, Item item) {
		for (Item elem : this.items) {
			if (elem != null && elem.getId().equals(id)) {
				elem = item;
				break;
			}
		}
	}

	/**
	 * удаление заявок
	 *
	 * @param id - уникальный ключ.
	 */
	public void delete(String id) {
		for (Item elem : this.items) {
			if (elem != null && elem.getId().equals(id)) {
				int index = this.items.indexOf(elem);
				this.items.remove(index);
				break;
			}
		}
	}

	/**
	 * получение списка всех заявок
	 *
	 * @return список заявок
	 */
	public List<Item> findAll() {
		return this.items;
	}

	/**
	 * получение списка по имени
	 *
	 * @param key - имя заявки
	 * @return - лист заявок
	 */
	public List<Item> findByName(String key) {
		List<Item> result = new ArrayList<>();
		for (Item elem : this.items) {
			if (elem != null && elem.getName().contains(key)) {
				result.add(elem);
			}
		}
		return result;
	}

	/**
	 * получение заявки по id
	 *
	 * @param id - уникальный ключ заявки.
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

