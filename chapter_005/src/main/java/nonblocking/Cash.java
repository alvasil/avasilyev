package nonblocking;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;

public class Cash {
	ConcurrentMap<Integer, Model> map = new ConcurrentHashMap<>();

	public void add(Model model) {
		this.map.put(model.getId(), model);
	}

	public void update(Model modelFirst) {
		this.map.computeIfPresent(modelFirst.getId(), new BiFunction<Integer, Model, Model>() {
			@Override
			public Model apply(Integer id, Model modelSecond) throws OptimisticException {
				if (modelFirst.getVersion() == modelSecond.getVersion()) {
					modelFirst.setName(modelSecond.getName());
				} else {
					throw new OptimisticException("wrong version");
				}
				return modelSecond;
			}
		});
	}

	public void delete(Model model) {
		this.map.remove(model.getId());
	}
}
