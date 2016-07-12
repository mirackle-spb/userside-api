package pro.consultit.userside.api.items;

public class CityListItem {
	private int id;
	private String name;
	private String type_name;

	protected CityListItem() {
	}

	public CityListItem(int id, String type_name, String name) {
		this.id = id;
		this.type_name = type_name;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public CityListItem setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public CityListItem setName(String name) {
		this.name = name;
		return this;
	}

	public String getType_name() {
		return type_name;
	}

	public CityListItem setType_name(String type_name) {
		this.type_name = type_name;
		return this;
	}
}
