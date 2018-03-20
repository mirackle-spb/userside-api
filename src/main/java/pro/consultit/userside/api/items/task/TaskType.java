package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskType {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;

	protected TaskType() {
	}

	public TaskType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public TaskType setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TaskType setName(String name) {
		this.name = name;
		return this;
	}
}
