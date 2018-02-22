package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
	public int ask(String question, int[] range) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = super.ask(question, range);
				invalid = false;
			} catch (MenuOutException moe) {
				System.out.println("Введите ключ меню!");
			} catch (NumberFormatException nfe) {
				System.out.println("Введите корректные данные!");
			}
		} while (invalid);
		return value;
	}
}