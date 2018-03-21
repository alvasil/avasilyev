package ru.job4j.generic;

public class AbstractStore<T extends Base> implements Store {
	private SimpleArray<Base> array = new SimpleArray<Base>(10);

	@Override
	public void add(Base model) {
		this.array.add(model);
	}

	@Override
	public boolean replace(String id, Base model) {
		boolean result = false;
		for (Base item : this.array) {
			if (item.getId().equals(id)) {
				item = model;
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean delete(String id) {
		boolean result = false;
		for (Base item : this.array) {
			if (item.getId().equals(id)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public T findById(String id) {
		Base result = null;
		for (Base item : this.array) {
			if (item.getId().equals(id)) {
				result = item;
			}
		}
		return (T) result;
	}
}
