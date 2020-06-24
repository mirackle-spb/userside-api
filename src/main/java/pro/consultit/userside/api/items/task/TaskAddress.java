package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAddress {
	@JsonProperty("addressId")
	private Integer addressId;
	@JsonProperty("apartament")
	private String apartament;
	@JsonProperty("text")
	private String text;

	protected TaskAddress() {
	}

	public TaskAddress(int cityId, int addressId, String apartament, String text) {
		this.addressId = addressId;
		this.apartament = apartament;
		this.text = text;
	}


	public int getAddressId() {
		return addressId;
	}

	public TaskAddress setAddressId(int addressId) {
		this.addressId = addressId;
		return this;
	}

	public String getApartament() {
		return apartament;
	}

	public TaskAddress setApartament(String apartament) {
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
