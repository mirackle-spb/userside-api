package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coordinates {
	@JsonProperty("lat")
	private Integer latitude;
	@JsonProperty("lon")
	private Integer longitude;

	private Coordinates() {
	}

	public Coordinates(final Integer latitude, final Integer longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(final Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(final Integer longitude) {
		this.longitude = longitude;
	}
}
