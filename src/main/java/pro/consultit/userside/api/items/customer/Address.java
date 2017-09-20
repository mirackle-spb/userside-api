package pro.consultit.userside.api.items.customer;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

	@JsonProperty("type")
	private String type;
	@JsonProperty("house_id")
	private int houseId;
	@JsonProperty("apartment")
	private Apartment apartment;
	@JsonProperty("entrance")
	private int entrance;
	@JsonProperty("floor")
	private String floor;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("house_id")
	public int getHouseId() {
		return houseId;
	}

	@JsonProperty("house_id")
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	@JsonProperty("apartment")
	public Apartment getApartment() {
		return apartment;
	}

	@JsonProperty("apartment")
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@JsonProperty("entrance")
	public int getEntrance() {
		return entrance;
	}

	@JsonProperty("entrance")
	public void setEntrance(int entrance) {
		this.entrance = entrance;
	}

	@JsonProperty("floor")
	public String getFloor() {
		return floor;
	}

	@JsonProperty("floor")
	public void setFloor(String floor) {
		this.floor = floor;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}