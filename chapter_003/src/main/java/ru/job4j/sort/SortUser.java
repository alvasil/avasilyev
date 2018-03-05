package ru.job4j.sort;

import java.util.*;

/**
 * В классе SortUser написать метод public Set<User> sort (List<User>),
 * который будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
 */
public class SortUser {
	private Set<User> result = new TreeSet<>();

	public Set<User> sort(List<User> users) {
		Collections.sort(users, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return Integer.compare(o1.getAge(), o2.getAge());
			}
		});
		return result;
	}
}
