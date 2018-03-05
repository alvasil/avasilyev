package ru.job4j.sort;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {
	@Test
	public void whenUnsortedListThenSorted() {
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
}
