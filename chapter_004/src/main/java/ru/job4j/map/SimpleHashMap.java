package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import static java.util.Objects.hash;

public class SimpleHashMap<K, V> implements Iterable {
	private Item[] hashTable;
	private int size;
	private int count;

	public SimpleHashMap(int size) {
		this.size = size;
		this.hashTable = new Item[size];
	}

	/**
	 * Метод вставляет элемент на позицию hash в таблице
	 * Таблица расширяется при недостатке места для элемента
	 *
	 * @param key   - ключ
	 * @param value - значение
	 * @return - false, если ключ уже есть
	 */
	boolean insert(K key, V value) {
		boolean result = true;
		Item item = new Item(value);
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null && hash(key) == i) {
				result = false;
				break;
			}
		}
		int hash = hash(key);
		if (hash < size) {
			hashTable[hash] = item;
			count++;
		} else {
			Item[] newTable = Arrays.copyOf(this.hashTable, size * 10);
			this.hashTable = newTable;
			this.hashTable[hash] = item;
			count++;
		}
		return result;
	}

	V get(K key) {
		V result = null;
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null && hash(key) == i) {
				result = (V) hashTable[i].getValue();
			}
		}
		return result;
	}

	boolean delete(K key) {
		boolean result = false;
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null && hash(key) == i) {
				hashTable[i] = null;
				result = true;
			}
		}
		return result;
	}

	@Override
	public Iterator iterator() {
		return new Iterator() {
			int i = 0;
			int index = 0;

			@Override
			public boolean hasNext() {
				return count > index;
			}

			@Override
			public Object next() {
				Object result = null;
				for (int n = i; n < hashTable.length; n++) {
					if (hashTable[n] != null) {
						result = hashTable[n++].getValue();
						i = n;
						index++;
						break;
					}
				}
				return result;
			}
		};
	}

	class Item<K> {
		private K value;

		public Item(K key) {
			this.value = key;
		}

		public K getValue() {
			return value;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Item<?> item = (Item<?>) o;
			return Objects.equals(value, item.value);
		}

		@Override
		public int hashCode() {
			return hash(value);
		}
	}

}
