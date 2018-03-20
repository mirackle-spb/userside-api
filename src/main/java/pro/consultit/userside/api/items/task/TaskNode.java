package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskNode {
	@JsonProperty("id")
	private Integer id;

	protected TaskNode() {
	}

	public TaskNode(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public TaskNode setId(int id) {
		this.id = id;
		return this;
	}
}
