package pro.consultit.userside.api.items.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityDistrictItem {
	@JsonProperty("id")
	private int id;
	@JsonProperty("city_id")
	private int cityId;
	@JsonProperty("name")
	private String name;

	protected CityDistrictItem() {
	}

	public CityDistrictItem(int id, int cityId, String name) {
		this.id = id;
		this.cityId = cityId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public CityDistrictItem setId(int id) {
		this.id = id;
		return this;
	}

	public int getCityId() {
		return cityId;
	}

	public CityDistrictItem setCityId(int cityId) {
		this.cityId = cityId;
		return this;
	}

	public String getName() {
		return name;
	}

	public CityDistrictItem setName(String name) {
		this.name = name;
		return this;
	}
}
