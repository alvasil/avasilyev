package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StoreTest {
	@Test
	public void whenUsingUserStore() {
		UserStore users = new UserStore();
		User first = new User("001");
		User second = new User("002");
		users.add(first);
		users.add(second);
		assertThat(users.findById("001"), is(first));
		assertThat(users.delete("001"), is(true));
		assertThat(users.delete("111"), is(false));
		assertThat(users.replace("001", second), is(true));
	}

	@Test
	public void whenUsingRoleStore() {
		RoleStore roles = new RoleStore();
		Role first = new Role("001");
		Role second = new Role("002");
		roles.add(first);
		roles.add(second);
		assertThat(roles.findById("001"), is(first));
		assertThat(roles.delete("001"), is(true));
		assertThat(roles.delete("111"), is(false));
		assertThat(roles.replace("001", second), is(true));
	}

}
