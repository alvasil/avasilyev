package ru.job4j.search;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
	@Test
	public void whenListConvertedToMap() {
		UserConvert user = new UserConvert();
		List<User> users = new LinkedList<>();
		User first = new User(111, "Alex", "Tula");
		User second = new User(222, "Nick", "Moscow");
		User third = new User(333, "Serg", "Sochi");
		users.add(first);
		users.add(second);
		users.add(third);
		HashMap<Integer, User> mapFromList = user.process(users);
		assertThat(mapFromList.get(333).getName(), is("Serg"));
	}
}
