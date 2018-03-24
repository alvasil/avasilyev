package ru.job4j.set;

import java.util.Arrays;

public class SetHash<E> {
	//массив для хранения элементов
	private Item[] hashTable;
	// размер таблицы
	public int size;
	//количество добавленных элементов в массив
	private int count;
	//вспомогательная переменная для генерации хэш-ключа
	private int index;

	public SetHash(int size) {
		this.size = size;
		this.hashTable = new Item[size];
	}

	boolean add(E value) {
		boolean result = true;
		Item item = new Item(value);
		for (Item e : hashTable) {
			if (value.equals(e)) {
				result = false;
				break;
			}
		}
		int hash = hash(value);
		if (hash < size) {
			hashTable[hash] = item;
			count++;
		} else {
			Item[] newTable = Arrays.copyOf(this.hashTable, size * 2);
			newTable[size++] = item;
			this.hashTable = newTable;
			count++;
		}
		return result;
	}

	boolean contains(E value) {
		boolean result = false;
		for (Item e : hashTable) {
			if (e != null && e.getKey().equals(value)) {
				result = true;
				break;
			}
		}
		return result;
	}

	boolean remove(E value) {
		boolean result = false;
		for (Item e : hashTable) {
			if (e != null && e.getKey().equals(value)) {
				result = true;
				e.setKey(null);
				break;
			}
		}
		count--;
		return result;
	}

	public int hash(E key) {
		int hash = (Integer) key % size + index;
		index++;
		return hash;
	}


	class Item<E> {
		private E key;

		public Item(E key) {
			this.key = key;
		}

		public E getKey() {
			return key;
		}

		public void setKey(E key) {
			this.key = key;
		}
	}


}
