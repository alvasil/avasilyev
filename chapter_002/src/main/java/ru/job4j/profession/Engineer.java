package ru.job4j.profession;

public class Engineer extends Profession {
	Profession engineer = new Profession("ТулГУ", 15, "Архитектор", 45, "Брунс");
	Building building = new Building();

	public void design(Building building) {
		System.out.println("Инженер " + engineer.getName() + "делает чертеж здания " + building.building("Останкино"));
	}

	public int calculate(Building building) {
		return 2 * (building.height * building.length + building.height * building.weight + building.length * building.weight);
	}

}