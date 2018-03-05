package ru.job4j.sort;

/**
 * Необходимо создать модель User с полями name, age.
 * Класс User должен реализовать интерфейс Comparable.
 */
public class User implements Comparable<User> {
	private String name;
	private int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(User o) {
		return (this.age - o.age);
	}
}