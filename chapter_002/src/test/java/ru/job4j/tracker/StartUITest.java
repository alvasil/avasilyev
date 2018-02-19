package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
	@Test
	public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
		Tracker tracker = new Tracker();     // создаём Tracker
		Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
		new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
		assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
	}

	@Test
	public void whenUpdateThenTrackerHasUpdatedValue() {
		Tracker tracker = new Tracker();
		Item itemFirst = tracker.add(new Item("name1", "desc1", tracker.generateId()));
		Item itemSecond = tracker.add(new Item("name2", "desc2", tracker.generateId()));
		itemSecond.setId(itemFirst.getId());
		Input input = new StubInput(new String[]{"2", itemFirst.getId(), itemSecond.getId(), "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findById(itemSecond.getId()).getName(), is("name1"));
	}

	@Test
	public void whenFindByIdThenShowItemName() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("name1", "desc1", tracker.generateId()));
		Input input = new StubInput(new String[]{"4", item.getId(), "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findById(item.getId()).getName(), is("name1"));
	}

	@Test
	public void whenFindByNameThenShowItemIdDesc() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("name1", "desc1", tracker.generateId()));
		Input input = new StubInput(new String[]{"5", item.getName(), "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll()[0].getId(), is(item.getId()));
	}
}
