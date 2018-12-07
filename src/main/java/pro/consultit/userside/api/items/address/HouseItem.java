package pro.consultit.userside.api.items.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HouseItem {


	private int id;
	@JsonProperty("city_district_id")
	private Integer districtId;
	@JsonProperty("city_id")
	private int cityId;
	@JsonProperty("province_id")
	private int regionId;
	@JsonProperty("district_id")
	private int regionDistrictId;
	@JsonProperty("street_id")
	private int streetId;
	@JsonProperty("number")
	private Integer number;
	@JsonProperty("custom_name")
	private String customName;
	@JsonProperty("block")
	private String block;
	@JsonProperty("additional_data")
	private Map<Integer, String> params = new HashMap();
	@JsonProperty("floor")
	private int floorCount;
	@JsonProperty("entrance")
	private int entranceCount;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("street2_id")
	private int street2Id;
	@JsonProperty("coordinates")
	private List<Double[]> coordinatesList = new ArrayList<>();
	private Integer number2;
	private String block2;

	protected HouseItem() {
	}

	public HouseItem(int id, Integer districtId, int cityId, int regionId, int regionDistrictId, int streetId, Integer number, String block, Map<Integer, String> params, int floorCount, int entranceCount, String fullName, int street2Id, Integer number2, String block2) {
		this.id = id;
		this.districtId = districtId;
		this.cityId = cityId;
		this.regionId = regionId;
		this.regionDistrictId = regionDistrictId;
		this.streetId = streetId;
		this.number = number;
		this.block = block;
		this.params = params;
		this.floorCount = floorCount;
		this.entranceCount = entranceCount;
		this.fullName = fullName;
		this.street2Id = street2Id;
		this.number2 = number2;
		this.block2 = block2;
	}

	public int getId() {
		return id;
	}

	public HouseItem setId(int id) {
		this.id = id;
		return this;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public HouseItem setDistrictId(Integer districtId) {
		this.districtId = districtId;
		return this;
	}

	public int getCityId() {
		return cityId;
	}

	public HouseItem setCityId(int cityId) {
		this.cityId = cityId;
		return this;
	}

	public int getRegionId() {
		return regionId;
	}

	public HouseItem setRegionId(int regionId) {
		this.regionId = regionId;
		return this;
	}

	public int getRegionDistrictId() {
		return regionDistrictId;
	}

	public HouseItem setRegionDistrictId(int regionDistrictId) {
		this.regionDistrictId = regionDistrictId;
		return this;
	}

	public int getStreetId() {
		return streetId;
	}

	public HouseItem setStreetId(int streetId) {
		this.streetId = streetId;
		return this;
	}

	public Integer getNumber() {
		return number;
	}

	public HouseItem setNumber(Integer number) {
		this.number = number;
		return this;
	}

	public String getBlock() {
		return block;
	}

	public HouseItem setBlock(String block) {
		this.block = block;
		return this;
	}

	public Map<Integer, String> getParams() {
		return params;
	}

	public HouseItem setParams(Map<Integer, String> params) {
		this.params = params;
		return this;
	}

	public int getFloorCount() {
		return floorCount;
	}

	public HouseItem setFloorCount(int floorCount) {
		this.floorCount = floorCount;
		return this;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(final String customName) {
		this.customName = customName;
	}

	public int getEntranceCount() {
		return entranceCount;
	}

	public HouseItem setEntranceCount(int entranceCount) {
		this.entranceCount = entranceCount;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public HouseItem setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public int getStreet2Id() {
		return street2Id;
	}

	public HouseItem setStreet2Id(int street2Id) {
		this.street2Id = street2Id;
		return this;
	}

	public Integer getNumber2() {
		return number2;
	}

	public HouseItem setNumber2(Integer number2) {
		this.number2 = number2;
		return this;
	}

	public String getBlock2() {
		return block2;
	}

	public HouseItem setBlock2(String block2) {
		this.block2 = block2;
		return this;
	}

	public HouseItem setCoordinatesList(List<Double[]> coordinatesList) {
		this.coordinatesList = coordinatesList;
		return this;
	}

	public List<Double[]> getCoordinatesList() {
		return coordinatesList;
	}
}
