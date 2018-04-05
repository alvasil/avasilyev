package ru.job4j.trading;

public class Order {

	public enum Type {
		ADD, DELETE
	}

	/**
	 * BID - покупка
	 * ASK - продажа
	 */
	public enum Action {
		BID, ASK
	}

	public int id;
	public String book;
	public Type type;
	public Action action;
	public int price;
	public int volume;

	public Order(int id, String book, Type type, Action action, int price, int volume) {
		this.id = id;
		this.book = book;
		this.type = type;
		this.action = action;
		this.price = price;
		this.volume = volume;
	}

	public Order(String book) {
		this.book = book;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Order order = (Order) o;
		if (id != order.id) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return id;
	}
}

