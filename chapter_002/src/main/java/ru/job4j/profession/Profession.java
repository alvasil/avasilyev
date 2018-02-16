package ru.job4j.profession;

public class Profession {
	String education;
	int workExperience;
	String specialization;
	int age;
	String name;

	public Profession() {
	}

	public Profession(String education, int workExperience, String specialization, int age, String name) {
		this.education = education;
		this.workExperience = workExperience;
		this.specialization = specialization;
		this.age = age;
		this.name = name;
	}

	public String getEducation() {
		return this.education;
	}

	public int getWorkExperience() {
		return this.workExperience;
	}

	public String getSpecialization() {
		return this.specialization;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

}