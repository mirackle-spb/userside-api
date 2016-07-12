package pro.consultit.userside.api.items;

/**
 * Created by kuzmich on 19.04.16.
 */
public class UserGroupListItem {
	private int id;
	private String name;

	public UserGroupListItem(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public UserGroupListItem setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserGroupListItem setName(String name) {
		this.name = name;
		return this;
	}
}
