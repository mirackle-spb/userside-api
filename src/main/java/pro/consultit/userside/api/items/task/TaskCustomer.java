package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskCustomer {
	@JsonProperty("id")
	private int id;
	@JsonProperty("fullName")
	private String fullName;

	protected TaskCustomer() {
	}

	public TaskCustomer(int id, String fullName) {
		this.id = id;
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public TaskCustomer setId(int id) {
		this.id = id;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public TaskCustomer setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}
}
