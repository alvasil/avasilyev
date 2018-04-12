package monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {
	@GuardedBy("this")
	private List<User> store;

	public UserStorage() {
		this.store = new ArrayList<>();
	}

	public synchronized boolean add(User user) {
		boolean result = false;
		if (!store.contains(user)) {
			this.store.add(user);
			result = true;
		}
		return result;
	}

	public synchronized boolean update(User user) {
		boolean result = false;
		for (User some : store) {
			if (some.getId() == user.getId()) {
				some = user;
				result = true;
			}
		}
		return result;
	}

	public synchronized boolean delete(User user) {
		boolean result = false;
		if (store.contains(user)) {
			store.remove(user);
			result = true;
		}
		return result;
	}

	public synchronized void transfer(int fromId, int toId, int amount) {
		for (User some : store) {
			if (some.getId() == fromId) {
				if (some.getAmount() >= amount) {
					some.setAmount(some.getAmount() - amount);
				} else {
					throw new UnsupportedOperationException("not enough money");
				}
			} else {
				throw new UnsupportedOperationException("no fromId User");
			}

			if (some.getId() == toId) {
				some.setAmount(some.getAmount() + amount);
			} else {
				throw new UnsupportedOperationException("no toId User");
			}

		}
	}
}
