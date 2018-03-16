//package com;
//
//
//public class Account {
//
//	double values; //поля желательно сделать приватными, чтобы соблюсти принцип инкапсуляции
//	String reqs;
//
//	public Account(double values, String requisites) {
//		this.values = values;
//		this.reqs = requisites;
//	}
//
//	public double getValues() {
//		return this.values;
//	}
//
//	public String getReqs() {
//		return this.reqs;
//	}
//
//	boolean transfer(Account destination, double amount) {
//		boolean success = false;
//		if (amount > 0 && amount < this.values && destination != null) { // надо указать amount <= this.values, чтобы можно было перевести всю сумму со счета
//			success = true;
//			this.values -= amount;
//			destination.values += amount;
//		}
//		return success;
//	}
//
//	// указать @Override
//	public String toString() {
//		String otvet; //можно объединить объявление переменной с ее инициализацией
//		otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
//		return otvet;
//	}
//	// указать @Override
//	// equals и hashCode должен еще учитывать поля для понятия эквивалентности
//	public boolean equals(Object o) {
//		if (this == o) {
//			return true;
//		}
//		if (o == null || getClass() != o.getClass()) {
//			return false;
//		}
//
//		Account account = (Account) o;
//
//		return this.reqs.equals(account.reqs);
//	}
//
//	// указать @Override
//	public int hashCode() {
//		return this.reqs.hashCode();
//	}
//}