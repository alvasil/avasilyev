package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Bank {
	private TreeMap<User, List<Account>> map = new TreeMap<>();

	//добавление пользователя.
	public void addUser(User user) {
		this.map.put(user, new ArrayList<>());
	}

	// удаление пользователя
	public void deleteUser(User user) {
		this.map.remove(user);
	}

	//добавить счёт пользователю.
	public void addAccountToUser(String passport, Account account) {
		for (User user : this.map.keySet()) {
			if (user.getPassport().equals(passport)) {
				this.map.get(user).add(account);
			}
		}
	}

	//удалить один из счетов пользователя
	public void deleteAccountFromUser(String passport, Account account) {
		for (User user : this.map.keySet()) {
			if (user.getPassport().equals(passport)) {
				this.map.get(user).remove(account);
			}
		}
	}

	//получить список счетов для пользователя
	public List<Account> getUserAccounts(String passport) {
		List<Account> result = new ArrayList<>();
		for (User user : this.map.keySet()) {
			if (user.getPassport().equals(passport)) {
				result = this.map.get(user);
			}
		}
		return result;
	}

	/**
	 * метод для перечисления денег с одного счёта на
	 * другой счёт: если счёт не найден или не	хватает денег
	 * на счёте srcAccount(с которого переводят) должен вернуть false.
	 *
	 * @param srcPassport  - номер паспорта пользователя, который делает перевод
	 * @param srcRequisite - реквизиты счета пользователя, который делает перевод
	 * @param destPassport - номер паспорта пользователя, на который переводят
	 * @param dstRequisite - реквизиты счета пользователя, на который переводят
	 * @param amount       - сумма перевода
	 * @return - true/false (можно/нельзя перевести)
	 */
	public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
		boolean canTransfer = false;
		User srcUser = null;
		User destUser = null;
		Account scrAccount = null;
		Account destAccount = null;
		// ищем пользователей с указанными паспортами
		for (User user : this.map.keySet()) {
			if (user.getPassport().equals(srcPassport)) {
				srcUser = user;
			}
			if (user.getPassport().equals(destPassport)) {
				destUser = user;
			}
		}
		// ищем аккаунты пользователя scrUser
		for (Account account : getUserAccounts(srcPassport)) {
			if (account.getRequisites().equals(srcRequisite)) {
				scrAccount = account;
			}
		}
		// ищем аккаунты пользователя destUser
		for (Account account : getUserAccounts(destPassport)) {
			if (account.getRequisites().equals(dstRequisite)) {
				destAccount = account;
			}
		}
		if (this.map.containsKey(srcUser) && this.map.containsKey(destUser) && getUserAccounts(srcPassport).contains(scrAccount) && getUserAccounts(destPassport).contains(destAccount)
				&& scrAccount.getValue() >= amount) {
			canTransfer = true;
		}
		return canTransfer;
	}
}
