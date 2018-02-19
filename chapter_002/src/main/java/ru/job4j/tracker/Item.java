package ru.job4j.tracker;

public class Item {
	private String id;
	private String name;
	private String desc;


	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Item(String name, String desc, String id) {
		this.name = name;
		this.desc = desc;
		this.id = id;
	}

	public Item(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public Item(String id) {
		this.id = id;
	}

}
