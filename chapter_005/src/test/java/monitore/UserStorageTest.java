package monitore;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserStorageTest {
	@Test
	public void whenTransferAmountsThenDifferentAmounts() {
		UserStorage store = new UserStorage();
		User first = new User(1, 100);
		User second = new User(2, 200);
		store.add(first);
		store.add(second);
		store.transfer(1, 2, 100);
		assertThat(first.getAmount(), is(0));
		assertThat(second.getAmount(), is(300));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void whenTransferFromNonexistentUserThenException() {
		UserStorage store = new UserStorage();
		User first = new User(1, 100);
		User second = new User(2, 200);
		store.add(first);
		store.add(second);
		store.transfer(3, 3, 100);
		assertThat(first.getAmount(), is(0));
		assertThat(second.getAmount(), is(300));
	}
}
