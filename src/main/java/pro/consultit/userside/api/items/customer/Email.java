package pro.consultit.userside.api.items.customer;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Email {

	@JsonProperty("address")
	private String address;
	@JsonProperty("flag_main")
	private int flagMain;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("flag_main")
	public int getFlagMain() {
		return flagMain;
	}

	@JsonProperty("flag_main")
	public void setFlagMain(int flagMain) {
		this.flagMain = flagMain;
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