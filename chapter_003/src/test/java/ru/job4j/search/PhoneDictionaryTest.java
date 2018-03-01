package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class PhoneDictionaryTest {
	@Test
	public void whenSearchByNameGetSurname() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(new Person("Alex", "Vasilyev", "123-456", "Tula"));
		phones.add(new Person("Bilbo", "Baggins", "100-200", "Land"));
		List<Person> members = phones.find("Bilbo");
		assertThat(members.iterator().next().getSurname(), is("Baggins"));
	}

	@Test
	public void whenSearchBySurnameGetName() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(new Person("Alex", "Vasilyev", "123-456", "Tula"));
		phones.add(new Person("Bilbo", "Baggins", "100-200", "Land"));
		List<Person> members = phones.find("Vas");
		assertThat(members.iterator().next().getName(), is("Alex"));
	}

	@Test
	public void whenSearchByPhoneGetName() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(new Person("Alex", "Vasilyev", "123-456", "Tula"));
		phones.add(new Person("Bilbo", "Baggins", "100-200", "Land"));
		List<Person> members = phones.find("100");
		assertThat(members.iterator().next().getName(), is("Bilbo"));
	}

	@Test
	public void whenSearchByAdressGetName() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(new Person("Alex", "Vasilyev", "123-456", "Tula"));
		phones.add(new Person("Bilbo", "Baggins", "100-200", "Shire"));
		List<Person> members = phones.find("Shire");
		assertThat(members.iterator().next().getName(), is("Bilbo"));
	}

}
