package ru.job4j.set;

import java.util.Arrays;

import static java.util.Objects.hash;

public class SetHash<E> {
	private Item[] hashTable;
	public int size;
	private int count;
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
			Item[] newTable = Arrays.copyOf(this.hashTable, size * 10);
			this.hashTable = newTable;
			this.hashTable[hash] = item;
			count++;
		}
		return result;
	}

	boolean contains(E value) {
		boolean result = false;
		if (hash(value) < hashTable.length && hashTable[hash(value)] != null) {
			result = true;
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
