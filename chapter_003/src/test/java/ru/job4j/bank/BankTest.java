package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BankTest {
	@Test
	public void whenAddNewAccountToUser() {
		Bank bank = new Bank();
		User vasilev = new User("Vasilev", "700-001");
		User petrov = new User("Petrov", "700-002");
		Account first = new Account(1000, "40701");
		Account second = new Account(2000, "40702");
		bank.addUser(vasilev);
		bank.addAccountToUser("700-001", first);
		bank.addUser(petrov);
		bank.addAccountToUser("700-002", second);
		assertTrue(bank.getUserAccounts("700-001").contains(first));
		assertTrue(bank.getUserAccounts("700-002").contains(second));
	}

	@Test
	public void whenDeleteAccountOfUser() {
		Bank bank = new Bank();
		User vasilev = new User("Vasilev", "700-001");
		Account first = new Account(1000, "40701");
		bank.addUser(vasilev);
		bank.addAccountToUser("700-001", first);
		bank.deleteAccountFromUser("700-001", first);
		assertFalse(bank.getUserAccounts("700-001").contains(first));
	}

	@Test
	public void whenDeleteUser() {
		Bank bank = new Bank();
		User vasilev = new User("Vasilev", "700-001");
		Account first = new Account(1000, "40701");
		bank.addUser(vasilev);
		bank.addAccountToUser("700-001", first);
		bank.deleteUser(vasilev);
		assertFalse(bank.getUserAccounts("700-001").contains(first));
	}

	@Test
	public void whenTransferMoney() {
		Bank bank = new Bank();
		User vasilev = new User("Vasilev", "700-001");
		User petrov = new User("Petrov", "700-002");
		Account first = new Account(1000, "40701");
		Account second = new Account(2000, "40702");
		bank.addUser(vasilev);
		bank.addAccountToUser("700-001", first);
		bank.addUser(petrov);
		bank.addAccountToUser("700-002", second);
		assertThat(bank.transferMoney("700-002", "40702", "700-001", "40701", 2000), is(true));
	}
}
