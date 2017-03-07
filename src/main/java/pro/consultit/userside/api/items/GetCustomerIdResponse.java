package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCustomerIdResponse {
	@JsonProperty("Result")
	private String result;
	@JsonProperty("Id")
	private Integer customerId;

	protected GetCustomerIdResponse() {
	}

	public GetCustomerIdResponse(String result, Integer customerId) {
		this.result = result;
		this.customerId = customerId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
