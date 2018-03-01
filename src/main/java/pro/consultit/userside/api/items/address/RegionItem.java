package pro.consultit.userside.api.items.address;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kuzmich on 18.04.16.
 */
public class RegionItem {

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;


	protected RegionItem() {
	}

	public RegionItem(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public RegionItem setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public RegionItem setName(String name) {
		this.name = name;
		return this;
	}
}
