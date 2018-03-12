package ru.job4j.sort;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserNewTest {
	@Test
	public void whenSortedByAge() {
		SortUserNew users = new SortUserNew();
		List<SortUserNew.UserNew> list = new LinkedList<>();
		SortUserNew.UserNew first = new SortUserNew.UserNew("nick", 32);
		SortUserNew.UserNew second = new SortUserNew.UserNew("serg", 43);
		SortUserNew.UserNew third = new SortUserNew.UserNew("alex", 30);
		list.add(first);
		list.add(second);
		list.add(third);
		users.sort(list);
		assertThat(list.get(0).getName(), is("alex"));
		assertThat(list.get(1).getName(), is("nick"));
		assertThat(list.get(2).getName(), is("serg"));
	}
}
