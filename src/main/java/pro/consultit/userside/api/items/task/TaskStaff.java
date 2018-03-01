package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskStaff {
	@JsonProperty("division")
	private Map<Integer, Integer> divisions = new HashMap<>();
	@JsonProperty("worker")
	private Map<Integer, Integer> workers = new HashMap<>();

	protected TaskStaff() {
	}

	public TaskStaff(Map<Integer, Integer> divisions, Map<Integer, Integer> workers) {
		this.divisions = divisions;
		this.workers = workers;
	}

	public Map<Integer, Integer> getDivisions() {
		return divisions;
	}

	public TaskStaff setDivisions(Map<Integer, Integer> divisions) {
		this.divisions = divisions;
		return this;
	}

	public Map<Integer, Integer> getWorkers() {
		return workers;
	}

	public TaskStaff setWorkers(Map<Integer, Integer> workers) {
		this.workers = workers;
		return this;
	}
}
