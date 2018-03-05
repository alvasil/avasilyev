//package ru.job4j.tracker;
//
//import org.junit.Test;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;
//
//public class StartUITest {
//	private final Tracker tracker = new Tracker();
//
//	public Item addNewItem() {
//		return this.tracker.add(new Item("name1", "desc1", tracker.generateId()));
//	}
//
//	@Test
//	public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
//		Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
//		new StartUI(input, this.tracker).init();
//		assertThat(this.tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//	}
//
//	@Test
//	public void whenUpdateThenTrackerHasUpdatedValue() {
//		Item itemFirst = addNewItem();
//		Item itemSecond = this.tracker.add(new Item("name2", "desc2", this.tracker.generateId()));
//		itemSecond.setId(itemFirst.getId());
//		Input input = new StubInput(new String[]{"2", itemFirst.getId(), itemSecond.getId(), "6"});
//		new StartUI(input, this.tracker).init();
//		assertThat(this.tracker.findById(itemSecond.getId()).getName(), is("name1"));
//	}
//
//	@Test
//	public void whenFindByIdThenShowItemName() {
//		Item item = addNewItem();
//		Input input = new StubInput(new String[]{"4", item.getId(), "6"});
//		new StartUI(input, this.tracker).init();
//		assertThat(this.tracker.findById(item.getId()).getName(), is("name1"));
//	}
//
//	@Test
//	public void whenFindByNameThenShowItemIdDesc() {
//		Item item = addNewItem();
//		Input input = new StubInput(new String[]{"5", item.getName(), "6"});
//		new StartUI(input, this.tracker).init();
//		assertThat(this.tracker.findAll()[0].getId(), is(item.getId()));
//	}
//}
