package nonblocking;

public class Model {
	private String name;
	private int id;
	private int version;

	public Model(int id, String name) {
		this.id = id;
		this.name = name;
		this.version++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}
}
