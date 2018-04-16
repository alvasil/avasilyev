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
	 * Добавляет стакан в систему (эмитент, без заявок).
	 * Создает в стакане 2 списка: BID/ASK
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
	 * Добавляет заявку в стакан эмитента.
	 * Стакан имеет списки: BID (сортировка по возрастанию) и ASK (сортировка по убыванию).
	 * Если заявка типа DELETE, то удаляет заявку с параметрами из листа BID или ASK.
	 *
	 * @param order - заявка эмитента
	 */
	public void addOrder(Order order) {
		List<Order> bookAsk = this.stocks.get(order.book).get(Order.Action.ASK);
		List<Order> bookBid = this.stocks.get(order.book).get(Order.Action.BID);

		if (order.type == Order.Type.ADD) {
			if (order.action == Order.Action.BID) {
				for (Order asks : bookAsk) {
					if (asks.price <= order.price && asks.volume == order.volume) {
						bookAsk.remove(asks);
						return;
					}
				}
				bookBid.add(order);
				bookBid.sort(ascending);
			} else {
				for (Order bids : bookBid) {
					if (bids.price >= order.price && bids.volume == order.volume) {
						bookBid.remove(bids);
						return;
					}
				}
				bookAsk.add(order);
				bookAsk.sort(descending);
			}

		} else {
			if (order.action == Order.Action.BID) {
				for (Order bidOrder : bookBid) {
					if (bidOrder.price == order.price) {
						bookBid.remove(bidOrder);
						break;
					}
				}
			} else {
				for (Order askOrder : bookAsk) {
					if (askOrder.price == order.price) {
						bookAsk.remove(askOrder);
						break;
					}
				}
			}
		}
	}

	public void show(Order order) {
		StringBuilder builder = new StringBuilder();
		for (Order orders : this.stocks.get(order.book).get(Order.Action.BID)) {
			builder.append(String.format("%s %d | %d$ |\n", orders.action, orders.volume, orders.price));
		}
		for (Order orders : this.stocks.get(order.book).get(Order.Action.ASK)) {
			builder.append(String.format("        | %d$ | %d %s\n", orders.price, orders.volume, orders.action));
		}
		System.out.println("**" + order.book + "**" + "\n" + builder);
	}

	public Map<String, Map<Order.Action, List<Order>>> getStocks() {
		return stocks;
	}
}
