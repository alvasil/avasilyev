package ru.job4j.trading;

import java.util.*;

public class OrderBook {
	private Map<String, Map<Order.Action, List<Order>>> stocks;

	public OrderBook() {
		this.stocks = new TreeMap<>();
	}

	/**
	 * сортировка по возрастанию
	 */
	public Comparator<Order> ascending = new Comparator<Order>() {
		@Override
		public int compare(Order o1, Order o2) {
			return o2.price - o1.price;
		}
	};

	/**
	 * сортировка по убыванию
	 */
	public Comparator<Order> descending = new Comparator<Order>() {
		@Override
		public int compare(Order o1, Order o2) {
			return o1.price - o2.price;
		}
	};

	/**
	 * метод добавляет стакан в систему (эмитент, без заявок)
	 *
	 * @param order - стакан эмитента
	 */
	public void addToBook(Order order) {
		Map<Order.Action, List<Order>> bidAsk = new TreeMap<>();
		this.stocks.put(order.book, bidAsk);
		bidAsk.put(Order.Action.BID, new ArrayList<>());
		bidAsk.put(Order.Action.ASK, new ArrayList<>());
	}

	/**
	 * метод добавляет заявку в стакан эмитента
	 * выбирает куда добавить: BID/ASK
	 * если заявка типа DELETE, то удаляет заявку с параметрами из листа BID или ASK
	 *
	 * @param order - заявка эмитента
	 */
	public void addOrder(Order order) {
		if (order.type == Order.Type.ADD) {
			if (order.action == Order.Action.BID) {
				for (String e : this.stocks.keySet()) {
					if (e.equals(order.book)) {
						for (Order asks : this.stocks.get(e).get(Order.Action.ASK)) {
							if (asks.price <= order.price && asks.volume == order.volume) {
								this.stocks.get(e).get(Order.Action.ASK).remove(asks);
								return;
							}

						}
					}
				}
				findBid(order).add(order);
				findBid(order).sort(ascending); //bid сортируем по возрастанию
			} else {
				for (String e : this.stocks.keySet()) {
					if (e.equals(order.book)) {
						for (Order bids : this.stocks.get(e).get(Order.Action.BID)) {
							if (bids.price >= order.price && bids.volume == order.volume) {
								this.stocks.get(e).get(Order.Action.BID).remove(bids);
								return;
							}

						}
					}
				}
				findAsk(order).add(order);
				findAsk(order).sort(descending); //ask сортируем по убыванию
			}

		} else {                                // если заявки типа DELETE
			if (order.action == Order.Action.BID) {
				for (Order bidOrder : findBid(order)) {
					if (bidOrder.price == order.price) {
						findBid(order).remove(bidOrder);
						break;
					}
				}
			} else {
				for (Order askOrder : findAsk(order)) {
					if (askOrder.price == order.price) {
						findAsk(order).remove(askOrder);
						break;
					}
				}
			}
		}
	}

	/**
	 * метод ищет лист BID по типу заявки
	 *
	 * @param order - заявка
	 * @return - лист BID
	 */
	public List<Order> findBid(Order order) {
		List<Order> result = null;
		for (String e : this.stocks.keySet()) {
			if (e.equals(order.book)) {
				if (order.action == Order.Action.BID) {
					result = this.stocks.get(e).get(Order.Action.BID);
				}
			}
		}
		return result;
	}

	/**
	 * метод ищет лист ASK по типу заявки
	 *
	 * @param order - заявка
	 * @return - лист ASK
	 */
	public List<Order> findAsk(Order order) {
		List<Order> result = null;
		for (String e : this.stocks.keySet()) {
			if (e.equals(order.book)) {
				if (order.action == Order.Action.ASK) {
					result = this.stocks.get(e).get(Order.Action.ASK);
				}
			}
		}
		return result;
	}

	public void show(Order order) {
		StringBuilder builder = new StringBuilder();
		for (String e : this.stocks.keySet()) {
			if (e.equals(order.book)) {
				for (Order orders : this.stocks.get(e).get(Order.Action.BID)) {
					builder.append(String.format("%s %d | %d$ |\n", orders.action, orders.volume, orders.price));
				}
				for (Order orders : this.stocks.get(e).get(Order.Action.ASK)) {
					builder.append(String.format("        | %d$ | %d %s\n", orders.price, orders.volume, orders.action));
				}
			}
		}
		System.out.println("**" + order.book + "**" + "\n" + builder);
	}
}
