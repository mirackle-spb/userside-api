package pro.consultit.userside.api.items.address;


import com.fasterxml.jackson.annotation.JsonProperty;

public class StreetItem {
	@JsonProperty("id")
	private int id;
	@JsonProperty("province_id")
	private int regionId;
	@JsonProperty("district_id")
	private int regionDistrictId;
	@JsonProperty("city_id")
	private int cityId;
	@JsonProperty("area_id")
	private int cityDistrictId;
	@JsonProperty("name")
	private String name;

	protected StreetItem() {
	}

	public StreetItem(int id, int cityId, String name) {
		this.id = id;
		this.cityId = cityId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public StreetItem setId(int id) {
		this.id = id;
		return this;
	}

	public int getCityId() {
		return cityId;
	}

	public StreetItem setCityId(int cityId) {
		this.cityId = cityId;
		return this;
	}

	public String getName() {
		return name;
	}

	public StreetItem setName(String name) {
		this.name = name;
		return this;
	}
}
