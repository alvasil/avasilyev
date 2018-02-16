package ru.job4j.profession;

public class Teacher extends Profession {
	Profession teacher = new Profession("ТулГУ", 15, "истории", 45, "Геннадий");
	Student student = new Student();

	public void teach(Student student) {
		System.out.println("Учитель " + teacher.getName() + "учит " + student.age(18) + "-летнего" + student.student("Колю") + teacher.getSpecialization());
	}

}