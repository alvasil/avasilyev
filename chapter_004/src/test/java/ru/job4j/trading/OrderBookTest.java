package ru.job4j.trading;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;


public class OrderBookTest {

	@Test
	public void whenAddOrdersThenBookFilledWithOrders() {
		OrderBook book = new OrderBook();
		Order gazprom = new Order("GAZPROM");
		Order lukoil = new Order("LUKOIL");
		book.addToBook(gazprom);
		book.addToBook(lukoil);

		assertThat(book.getStocks().size(), is(2));

		Order gazBid1 = new Order(1, "GAZPROM", Order.Type.ADD, Order.Action.BID, 120, 100);
		Order gazAsk1 = new Order(5, "GAZPROM", Order.Type.ADD, Order.Action.ASK, 125, 200);
		book.addOrder(gazBid1);
		book.addOrder(gazAsk1);

		assertTrue(book.getStocks().get("GAZPROM").get(Order.Action.BID).contains(gazBid1));
		assertTrue(book.getStocks().get("GAZPROM").get(Order.Action.ASK).contains(gazAsk1));
	}

	@Test
	public void whenBookHaveOrderTypesDeleteThenNoOrdersInBook() {
		OrderBook book = new OrderBook();
		book.addToBook(new Order("GAZPROM"));
		book.addOrder(new Order(1, "GAZPROM", Order.Type.ADD, Order.Action.BID, 120, 100));
		book.addOrder(new Order(2, "GAZPROM", Order.Type.DELETE, Order.Action.BID, 120, 100));

		assertThat(book.getStocks().get("GAZPROM").get(Order.Action.BID).size(), is(0));
		assertThat(book.getStocks().get("GAZPROM").get(Order.Action.ASK).size(), is(0));
	}

	@Test
	public void whenOrdersCanBeMatchedThenEmptyOrderBook() {
		OrderBook book = new OrderBook();
		book.addToBook(new Order("LUKOIL"));

		book.addOrder(new Order(1, "LUKOIL", Order.Type.ADD, Order.Action.ASK, 40, 100));
		book.addOrder(new Order(2, "LUKOIL", Order.Type.ADD, Order.Action.BID, 50, 100));
		book.addOrder(new Order(3, "LUKOIL", Order.Type.ADD, Order.Action.BID, 70, 100));
		book.addOrder(new Order(4, "LUKOIL", Order.Type.ADD, Order.Action.ASK, 40, 100));

		assertThat(book.getStocks().get("LUKOIL").get(Order.Action.BID).size(), is(0));
		assertThat(book.getStocks().get("LUKOIL").get(Order.Action.ASK).size(), is(0));
	}

	@Test
	public void demoFilledWithOrdersBook() {
		OrderBook book = new OrderBook();
		Order rosneft = new Order("ROSNEFT");
		book.addToBook(rosneft);

		book.addOrder(new Order(11, "ROSNEFT", Order.Type.ADD, Order.Action.BID, 500, 300));
		book.addOrder(new Order(12, "ROSNEFT", Order.Type.ADD, Order.Action.BID, 505, 400));
		book.addOrder(new Order(13, "ROSNEFT", Order.Type.ADD, Order.Action.BID, 495, 200));
		book.addOrder(new Order(21, "ROSNEFT", Order.Type.ADD, Order.Action.ASK, 510, 100));
		book.addOrder(new Order(22, "ROSNEFT", Order.Type.ADD, Order.Action.ASK, 515, 200));
		book.addOrder(new Order(23, "ROSNEFT", Order.Type.ADD, Order.Action.ASK, 525, 300));

		book.show(rosneft);
	}
}
