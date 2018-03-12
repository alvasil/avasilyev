package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUserNew {
	private Set<UserNew> result = new TreeSet<>();

	public Set<UserNew> sort(List<UserNew> users) {
		users.sort(new Comparator<UserNew>() {
			@Override
			public int compare(UserNew o1, UserNew o2) {
				return o1.compareTo(o2);
			}
		});
		this.result.addAll(users);
		return this.result;
	}

	static class UserNew implements Comparable<UserNew> {
		private String name;
		private int age;

		public UserNew(String name, int age) {
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
		public int compareTo(UserNew o) {
			return Integer.valueOf(this.age).compareTo(o.getAge());
		}
	}

}
