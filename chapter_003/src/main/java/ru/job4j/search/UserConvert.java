package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

/**
 * Написать программу преобразования List в Map.
 */
public class UserConvert {
	private HashMap<Integer, User> mapList = new HashMap<>();

	/**
	 * метод принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и соответствующим ему User.
	 *
	 * @param list - список пользователей
	 * @return - список типа Map
	 */
	public HashMap<Integer, User> process(List<User> list) {
		for (User user : list) {
			this.mapList.put(user.getId(), user);
		}
		return this.mapList;

	}
}
