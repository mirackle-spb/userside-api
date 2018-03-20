package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskState {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("systemRole")
	private Integer systemRole;

	protected TaskState() {
	}

	public TaskState(int id, String name, int systemRole) {
		this.id = id;
		this.name = name;
		this.systemRole = systemRole;
	}

	public int getId() {
		return id;
	}

	public TaskState setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TaskState setName(String name) {
		this.name = name;
		return this;
	}

	public int getSystemRole() {
		return systemRole;
	}

	public TaskState setSystemRole(int systemRole) {
		this.systemRole = systemRole;
		return this;
	}
}
