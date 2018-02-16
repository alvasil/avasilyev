package ru.job4j.profession;

public class Doctor extends Profession {
	Profession doctor = new Profession("ТулГУ", 5, "хирург", 35, "Иван");
	Pacient pacient = new Pacient();

	public void heal(Pacient pacient) {
		System.out.println("Доктор " + doctor.getName() + "лечит" + pacient.pacient("Сергея"));
	}

}