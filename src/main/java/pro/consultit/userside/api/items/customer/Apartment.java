package pro.consultit.userside.api.items.customer;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Apartment {

	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("number")
	private String number;
	@JsonProperty("block")
	private String block;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("full_name")
	public String getFullName() {
		return fullName;
	}

	@JsonProperty("full_name")
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@JsonProperty("number")
	public String getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(String number) {
		this.number = number;
	}

	@JsonProperty("block")
	public String getBlock() {
		return block;
	}

	@JsonProperty("block")
	public void setBlock(String block) {
		this.block = block;
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