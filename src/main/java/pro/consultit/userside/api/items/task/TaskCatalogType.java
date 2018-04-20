package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskCatalogType {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("group_id")
	private Integer groupId;

	@JsonProperty("allow_state")
	private Map<Integer, Integer> allowState = new HashMap<>();

	protected TaskCatalogType() {
	}

	public TaskCatalogType(Integer id, String name, Integer groupId) {
		this.id = id;
		this.name = name;
		this.groupId = groupId;
	}

	public Integer getId() {
		return id;
	}

	public TaskCatalogType setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TaskCatalogType setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public TaskCatalogType setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	public Map<Integer, Integer> getAllowState() {
		return allowState;
	}
}
