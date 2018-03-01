package pro.consultit.userside.api.items.address;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kuzmich on 18.04.16.
 */
public class RegionDistrictItem {

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;


	protected RegionDistrictItem() {
	}

	public RegionDistrictItem(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public RegionDistrictItem setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public RegionDistrictItem setName(String name) {
		this.name = name;
		return this;
	}
}
