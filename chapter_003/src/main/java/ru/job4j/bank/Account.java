package ru.job4j.bank;

public class Account implements Comparable<Account> {
	private double value;
	private String requisites;

	public Account(double value, String requisites) {
		this.value = value;
		this.requisites = requisites;
	}

	public double getValue() {
		return value;
	}

	public String getRequisites() {
		return requisites;
	}

	@Override
	public int compareTo(Account o) {
		return requisites.compareTo(o.getRequisites());
	}
}
