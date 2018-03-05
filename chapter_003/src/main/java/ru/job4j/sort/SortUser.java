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

	/**
	 * сортировка по длине имени
	 *
	 * @return - отсортированный по длине имени лист
	 */
	public List<User> sortNameLength(List<User> users) {
		users.sort(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return Integer.compare(o1.getName().length(), o2.getName().length());
			}
		});
		return users;
	}

	/**
	 * определить Comparator для метода Collections.sort и отсортировать List<User> по обоим полям,
	 * сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
	 *
	 * @return - отсортированный по имени и возрасту лист
	 */
	public List<User> sortByAllFields(List<User> users) {
		users.sort(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				int flag = o1.getName().compareTo(o2.getName());
				if (flag == 0) {
					flag = Integer.compare(o1.getAge(), o2.getAge());
				}
				return flag;
			}
		});
		return users;
	}
}
