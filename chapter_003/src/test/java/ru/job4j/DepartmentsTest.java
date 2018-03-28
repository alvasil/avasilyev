package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DepartmentsTest {
	private String[] structure = new String[]{
			"K1\\SK1",
			"K1\\SK2",
			"K1\\SK1\\SSK1",
			"K1\\SK1\\SSK2",
			"K2",
			"K2\\SK1\\SSK1",
			"K2\\SK1\\SSK2"
	};

	@Test
	//сортировка по возрастанию
	public void whenStructureThenAscending() {
		Departments depts = new Departments();
		String[] expected = {
				"K1",
				"K1\\SK1",
				"K1\\SK1\\SSK1",
				"K1\\SK1\\SSK2",
				"K1\\SK2",
				"K2",
				"K2\\SK1",
				"K2\\SK1\\SSK1",
				"K2\\SK1\\SSK2"
		};
		String[] result = depts.strAscending(structure);
		assertThat(result, is(expected));
	}

	@Test
	//сортировка по убыванию
	public void whenStructureThenDescending() {
		Departments depts = new Departments();
		String[] expected = {
				"K2",
				"K2\\SK1",
				"K2\\SK1\\SSK2",
				"K2\\SK1\\SSK1",
				"K1",
				"K1\\SK2",
				"K1\\SK1",
				"K1\\SK1\\SSK2",
				"K1\\SK1\\SSK1"
		};
		String[] result = depts.sortDescend(structure);
		assertThat(result, is(expected));
	}
}
