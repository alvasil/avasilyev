package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
	private Scanner input = new Scanner(System.in);

	public String ask(String question) {
		System.out.print(question);
		return input.nextLine();
	}

	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (value == key) {
				exist = true;
			}
		}
		if (exist) {
			return key;
		} else {
			throw new MenuOutException("Out of menu");
		}
	}
}
