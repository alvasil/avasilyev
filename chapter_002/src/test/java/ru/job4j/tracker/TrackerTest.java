package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {
	@Test
	public void whenAddNewItemThenTrackerHasSameItem() {
		Tracker tracker = new Tracker();
		Item item = new Item("test1", "testDescription");
		tracker.add(item);
		assertThat(tracker.findAll().get(0), is(item));
	}

	@Test
	public void whenReplaceNameThenReturnNewName() {
		Tracker tracker = new Tracker();
		Item previous = new Item("test1", "testDescription", tracker.generateId());
		tracker.add(previous);
		Item next = new Item("test2", "testDescription2", tracker.generateId());
		// Проставляем старый id из previous, который был сгенерирован выше.
		next.setId(previous.getId());
		// Обновляем заявку в трекере.
		tracker.replace(previous.getId(), next);
		// Проверяем, что заявка с таким id имеет новые имя test2.
		assertThat(tracker.findById(next.getId()).getName(), is("test1"));
	}

	@Test
	public void whenDeleteItemByIdThenNewArray() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1", "testDescription");
		tracker.add(item1);
		Item item2 = new Item("test2", "testDescription");
		tracker.add(item2);
		Item item3 = new Item("test3", "testDescription");
		tracker.add(item3);
		tracker.delete(item2.getId());
		assertThat(tracker.findAll().get(1), is(item3));
	}

	@Test
	public void whenAddItemsThenFindAll() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1", "testDescription");
		tracker.add(item1);
		Item item2 = new Item("test2", "testDescription");
		tracker.add(item2);
		Item item3 = new Item("test3", "testDescription");
		tracker.add(item3);
		List<Item> expect = tracker.findAll();
		assertThat(expect.contains(item3), is(true));
	}

	@Test
	public void whenAddItemThenFindByName() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1", "testDescription", tracker.generateId());
		tracker.add(item1);
		Item item2 = new Item("test2", "testDescription", tracker.generateId());
		tracker.add(item2);
		List<Item> expect = tracker.findByName(item1.getName());
		assertThat(tracker.findAll().get(0), is(expect.get(0)));
	}

	@Test
	public void whenAddItemThenFindById() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1", "testDescription", tracker.generateId());
		tracker.add(item1);
		Item item2 = new Item("test2", "testDescription", tracker.generateId());
		tracker.add(item2);
		Item expect = tracker.findById(item1.getId());
		assertThat(item1, is(expect));
	}
}