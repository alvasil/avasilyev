package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
	private String name;
	private int children;
	private Calendar birthday;

	public User(String name, int children) {
		this.name = name;
		this.children = children;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, children, birthday);
	}

	public static void main(String[] args) {
		User first = new User("alex", 2);
		User second = new User("alex", 2);
		Map<User, Object> map = new HashMap<>();
		map.put(first, "first");
		map.put(second, "second");
		System.out.println(map);
	}
}


