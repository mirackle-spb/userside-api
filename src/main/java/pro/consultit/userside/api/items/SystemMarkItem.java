package pro.consultit.userside.api.items;

public class SystemMarkItem {
	int id;
	String name;

	protected SystemMarkItem() {
	}

	public SystemMarkItem(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public SystemMarkItem setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public SystemMarkItem setName(String name) {
		this.name = name;
		return this;
	}
}
