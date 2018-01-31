package ru.job4j;

public class StringContains {
	boolean contains(String origin, String sub) {
		int counter = 0;
		int originLength = origin.length();
		int subLength = sub.length();
		for (int i = 0; i < originLength; i++) {
			for (int j = 0; j < subLength; j++) {
				if (origin.charAt(i) == sub.charAt(j)) {
					counter++;
				}
			}
		}
		return counter >= subLength;
	}
}
