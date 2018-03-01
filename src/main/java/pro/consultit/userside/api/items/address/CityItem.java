package pro.consultit.userside.api.items.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityItem {
	@JsonProperty("id")
	private int id;
	@JsonProperty("province_id")
	private int provinceId;
	@JsonProperty("district_id")
	private int districtId;
	@JsonProperty("name")
	private String name;

	protected CityItem() {
	}

	public CityItem(int id, int provinceId, int districtId, String name) {
		this.id = id;
		this.provinceId = provinceId;
		this.districtId = districtId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public CityItem setId(int id) {
		this.id = id;
		return this;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public CityItem setProvinceId(int provinceId) {
		this.provinceId = provinceId;
		return this;
	}

	public int getDistrictId() {
		return districtId;
	}

	public CityItem setDistrictId(int districtId) {
		this.districtId = districtId;
		return this;
	}

	public String getName() {
		return name;
	}

	public CityItem setName(String name) {
		this.name = name;
		return this;
	}
}
