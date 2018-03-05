package ru.job4j.sort;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {
	@Test
	public void whenSortByAge() {
		SortUser users = new SortUser();
		List<User> list = new LinkedList<>();
		User first = new User("nick", 32);
		User second = new User("serg", 43);
		User third = new User("alex", 30);
		list.add(first);
		list.add(second);
		list.add(third);
		users.sort(list);
		assertThat(list.get(0).getName(), is("alex"));
	}

	@Test
	public void whenSortByNameLength() {
		SortUser users = new SortUser();
		List<User> list = new LinkedList<>();
		User first = new User("nickolai", 32);
		User second = new User("sergey", 43);
		User third = new User("alexander", 30);
		list.add(first);
		list.add(second);
		list.add(third);
		users.sortNameLength(list);
		assertThat(list.get(0).getName(), is("sergey"));
	}

	@Test
	public void whenSortByAlpabetAndThenByAge() {
		SortUser users = new SortUser();
		List<User> list = new LinkedList<>();
		User first = new User("nick", 20);
		User second = new User("nick", 18);
		User third = new User("alex", 35);
		User forth = new User("alex", 30);
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(forth);
		users.sortByAllFields(list);
		assertThat(list.get(0).getAge(), is(30));
	}
}
