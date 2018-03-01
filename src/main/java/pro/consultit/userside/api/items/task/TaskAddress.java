package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAddress {
	@JsonProperty("cityId")
	private int cityId;
	@JsonProperty("houseId")
	private int houseId;
	@JsonProperty("apartament")
	private int apartament;
	@JsonProperty("text")
	private String text;

	protected TaskAddress() {
	}

	public TaskAddress(int cityId, int houseId, int apartament, String text) {
		this.cityId = cityId;
		this.houseId = houseId;
		this.apartament = apartament;
		this.text = text;
	}

	public int getCityId() {
		return cityId;
	}

	public TaskAddress setCityId(int cityId) {
		this.cityId = cityId;
		return this;
	}

	public int getHouseId() {
		return houseId;
	}

	public TaskAddress setHouseId(int houseId) {
		this.houseId = houseId;
		return this;
	}

	public int getApartament() {
		return apartament;
	}

	public TaskAddress setApartament(int apartament) {
		this.apartament = apartament;
		return this;
	}

	public String getText() {
		return text;
	}

	public TaskAddress setText(String text) {
		this.text = text;
		return this;
	}
}
