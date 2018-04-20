package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskCatalogState {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("sysrole")
	private Integer sysrole;

	protected TaskCatalogState() {
	}

	public TaskCatalogState(Integer id, String name, Integer sysrole) {
		this.id = id;
		this.name = name;
		this.sysrole = sysrole;
	}

	public Integer getId() {
		return id;
	}

	public TaskCatalogState setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TaskCatalogState setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getSysrole() {
		return sysrole;
	}

	public TaskCatalogState setSysrole(Integer sysrole) {
		this.sysrole = sysrole;
		return this;
	}
}
