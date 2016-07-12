package pro.consultit.userside.api.items;

public class UserStateListItem {
	private int id;
	private String name;
	private String functional;

	public UserStateListItem(int id, String name, String functional) {
		this.id = id;
		this.name = name;
		this.functional = functional;
	}

	public int getId() {
		return id;
	}

	public UserStateListItem setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserStateListItem setName(String name) {
		this.name = name;
		return this;
	}

	public String getFunctional() {
		return functional;
	}

	public UserStateListItem setFunctional(String functional) {
		this.functional = functional;
		return this;
	}
}

