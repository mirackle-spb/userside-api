package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kuzmich on 18.04.16.
 */
public class DistrictListItem {
	private int id;
	@JsonProperty("city_id")
	private int cityId;
	private String name;


	protected DistrictListItem() {
	}

	public DistrictListItem(int id, int cityId, String name) {
		this.id = id;
		this.cityId = cityId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public DistrictListItem setId(int id) {
		this.id = id;
		return this;
	}

	public int getCityId() {
		return cityId;
	}

	public DistrictListItem setCityId(int cityId) {
		this.cityId = cityId;
		return this;
	}

	public String getName() {
		return name;
	}

	public DistrictListItem setName(String name) {
		this.name = name;
		return this;
	}
}
