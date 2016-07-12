package pro.consultit.userside.api.items;


import com.fasterxml.jackson.annotation.JsonProperty;

public class StreetListItem {
	private int id;
	@JsonProperty("city_id")
	private int cityId;
	@JsonProperty("full_name")
	private String fullName;

	protected StreetListItem() {
	}

	public StreetListItem(int id, int cityId, String fullName) {
		this.id = id;
		this.cityId = cityId;
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public StreetListItem setId(int id) {
		this.id = id;
		return this;
	}

	public int getCityId() {
		return cityId;
	}

	public StreetListItem setCityId(int cityId) {
		this.cityId = cityId;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public StreetListItem setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}
}
