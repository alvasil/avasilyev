package ru.job4j.trading;

import org.junit.Test;

public class OrderBookTest {
	@Test
	public void whenAddOrdersToBook() {
		OrderBook book = new OrderBook();
		Order gazprom = new Order("GAZPROM");
		Order lukoil = new Order("LUKOIL");
		Order rosneft = new Order("ROSNEFT");
		book.addToBook(gazprom);
		book.addToBook(lukoil);
		book.addToBook(rosneft);

		/**
		 * проверка на работу заявок типа ADD/DELETE
		 */
		Order gazBid1 = new Order(1, "GAZPROM", Order.Type.ADD, Order.Action.BID, 120, 100);
		Order gazAsk1 = new Order(5, "GAZPROM", Order.Type.ADD, Order.Action.ASK, 125, 200);
		Order gazDeleteBid1 = new Order(2, "GAZPROM", Order.Type.DELETE, Order.Action.BID, 120, 100);
		Order gazDeleteAsk1 = new Order(5, "GAZPROM", Order.Type.DELETE, Order.Action.ASK, 125, 200);

		book.addOrder(gazBid1);
		book.addOrder(gazDeleteBid1); //удаляет gazBid1
		book.addOrder(gazAsk1);
		book.addOrder(gazDeleteAsk1); //удаляет gazAsk1

		book.show(gazprom); // пустой стакан

		/**
		 * проверка на работу заявок, которые могут быть совмещены при добавлении:
		 * ASK.price < = BID.price и наоборот
		 */
		Order lukAsk1 = new Order(1, "LUKOIL", Order.Type.ADD, Order.Action.ASK, 40, 100);
		Order lukBid1 = new Order(2, "LUKOIL", Order.Type.ADD, Order.Action.BID, 50, 100);
		Order lukBid2 = new Order(3, "LUKOIL", Order.Type.ADD, Order.Action.BID, 70, 100);
		Order lukAsk2 = new Order(4, "LUKOIL", Order.Type.ADD, Order.Action.ASK, 40, 100);
		book.addOrder(lukAsk1);
		book.addOrder(lukBid1); //удаляет lukAsk1, т.к. заявки можно совместить
		book.addOrder(lukBid2);
		book.addOrder(lukAsk2); //удаляет lukBid2, т.к. заявки можно совместить

		book.show(lukoil); //пустой стакан

		/**
		 * демонтрация обычного наполненого стакана
		 */
		Order rosneftBid1 = new Order(11, "ROSNEFT", Order.Type.ADD, Order.Action.BID, 500, 300);
		Order rosneftBid2 = new Order(12, "ROSNEFT", Order.Type.ADD, Order.Action.BID, 505, 400);
		Order rosneftBid3 = new Order(13, "ROSNEFT", Order.Type.ADD, Order.Action.BID, 495, 200);
		Order rosneftAsk1 = new Order(21, "ROSNEFT", Order.Type.ADD, Order.Action.ASK, 510, 100);
		Order rosneftAsk2 = new Order(22, "ROSNEFT", Order.Type.ADD, Order.Action.ASK, 515, 200);
		Order rosneftAsk3 = new Order(23, "ROSNEFT", Order.Type.ADD, Order.Action.ASK, 525, 300);
		book.addOrder(rosneftBid1);
		book.addOrder(rosneftBid2);
		book.addOrder(rosneftBid3);
		book.addOrder(rosneftAsk1);
		book.addOrder(rosneftAsk2);
		book.addOrder(rosneftAsk3);

		book.show(rosneft);


	}
}
