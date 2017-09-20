package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdArrayResponse {
	@JsonProperty("Result")
	private String result;
	@JsonProperty("Id")
	private List<Integer> customerId = new ArrayList<>();

	protected IdArrayResponse() {
	}

	public IdArrayResponse(String result, List<Integer> customerId) {
		this.result = result;
		this.customerId = customerId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<Integer> getCustomerId() {
		return customerId;
	}

	public void setCustomerId(List<Integer> customerId) {
		this.customerId = customerId;
	}
}
