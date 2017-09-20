package pro.consultit.userside.api.items.customer;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpMac {

	@JsonProperty("ip")
	private String ip;
	@JsonProperty("mac")
	private String mac;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("ip")
	public String getIp() {
		return ip;
	}

	@JsonProperty("ip")
	public void setIp(String ip) {
		this.ip = ip;
	}

	@JsonProperty("mac")
	public String getMac() {
		return mac;
	}

	@JsonProperty("mac")
	public void setMac(String mac) {
		this.mac = mac;
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
