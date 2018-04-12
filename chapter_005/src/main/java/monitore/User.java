package monitore;

import net.jcip.annotations.GuardedBy;

public class User {
	@GuardedBy("this")
	private int id;

	@GuardedBy("this")
	private int amount;

	public User(int id, int amount) {
		this.id = id;
		this.amount = amount;
	}

	public synchronized int getId() {
		return id;
	}

	public synchronized int getAmount() {
		return amount;
	}

	public synchronized void setAmount(int amount) {
		this.amount = amount;
	}
}
