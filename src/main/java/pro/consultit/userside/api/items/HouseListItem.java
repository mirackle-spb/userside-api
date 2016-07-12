package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HouseListItem {
	private int id;
	@JsonProperty("city_district_id")
	private Integer districtId;
	@JsonProperty("street_id")
	private int streetId;
	private Integer number;
	private String block;
	@JsonProperty("additional_data")
	private Map<Integer, AdditionalParam> params = new HashMap();
	@JsonProperty("floor")
	private int floorCount;
	@JsonProperty("entrance")
	private int entranceCount;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("street2_id")
	private int street2Id;
	private Integer number2;
	private String block2;

	protected HouseListItem() {
	}

	public HouseListItem(int id, Integer districtId, int streetId, Integer number, String block) {
		this.id = id;
		this.districtId = districtId;
		this.streetId = streetId;
		this.number = number;
		this.block = block;
	}

	public int getId() {
		return id;
	}

	public HouseListItem setId(int id) {
		this.id = id;
		return this;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public HouseListItem setDistrictId(Integer districtId) {
		this.districtId = districtId;
		return this;
	}

	public int getStreetId() {
		return streetId;
	}

	public HouseListItem setStreetId(int streetId) {
		this.streetId = streetId;
		return this;
	}

	public Integer getNumber() {
		return number;
	}

	public HouseListItem setNumber(Integer number) {
		this.number = number;
		return this;
	}

	public String getBlock() {
		return block;
	}

	public HouseListItem setBlock(String block) {
		this.block = block;
		return this;
	}

	public int getFloorCount() {
		return floorCount;
	}

	public HouseListItem setFloorCount(int floorCount) {
		this.floorCount = floorCount;
		return this;
	}

	public HouseListItem setEntranceCount(int entranceCount) {
		this.entranceCount = entranceCount;
		return this;
	}

	public HouseListItem setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public HouseListItem setStreet2Id(int street2Id) {
		this.street2Id = street2Id;
		return this;
	}

	public HouseListItem setNumber2(Integer number2) {
		this.number2 = number2;
		return this;
	}

	public HouseListItem setBlock2(String block2) {
		this.block2 = block2;
		return this;
	}

	public int getEntranceCount() {
		return entranceCount;
	}


	public String getFullName() {
		return fullName;
	}



	public int getStreet2Id() {
		return street2Id;
	}



	public Integer getNumber2() {
		return number2;
	}



	public String getBlock2() {
		return block2;
	}


	public Map<Integer, AdditionalParam> getParams() {
		return params;
	}

}
