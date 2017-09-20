package pro.consultit.userside.api.items.customer;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Phone {

	@JsonProperty("number")
	private String number;
	@JsonProperty("flag_main")
	private int flagMain;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("number")
	public String getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(String number) {
		this.number = number;
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
