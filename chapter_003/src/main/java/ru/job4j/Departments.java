package ru.job4j;

import java.util.*;

public class Departments {

	/**
	 * метод добавляет в начальную структуру недостающие элементы
	 * сортирует по возрастанию
	 *
	 * @param structure начальная "неправильная" структура
	 * @return - структура с недостающими отделами
	 */
	public String[] strAscending(String[] structure) {
		Set<String> set = new TreeSet<>();
		for (String element : structure) {
			for (int i = 0; i < element.length(); i++) {
				if (element.charAt(i) == '\\') {
					set.add(element.substring(0, i));
				}
				if (element.endsWith("1") || element.endsWith("2")) {
					set.add(element.substring(0, element.length()));
				}
			}
		}
		return set.toArray(new String[set.size()]);
	}


	/**
	 * сортировка по убыванию
	 *
	 * @param structure - начальный массив строк
	 * @return - отсортированный массив строк
	 */

	public String[] sortDescend(String[] structure) {
		List<String> list = new ArrayList<>();
		String[] ascend = strAscending(structure);
		list.addAll(Arrays.asList(ascend));
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int result = 0;
				int min = Math.min(o1.length(), o2.length());
				for (int i = 0; i < min; i++) {
					if (o1.charAt(i) != o2.charAt(i)) {
						if (o1.charAt(i) != '\\' && o2.charAt(i) != '\\') {
							result = o2.charAt(i) - o1.charAt(i);
							break;
						}
					}
				}
				return result;
			}

		});
		return list.toArray(new String[list.size()]);
	}
}
