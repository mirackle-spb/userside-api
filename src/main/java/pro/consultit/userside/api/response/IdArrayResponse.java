package pro.consultit.userside.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdArrayResponse extends DefaultResponse {
	@JsonProperty("Id")
	private List<Integer> customerId = new ArrayList<>();

	protected IdArrayResponse() {
		super();
	}

	public IdArrayResponse(String result, String error) {
		super(result, error);
	}

	public List<Integer> getCustomerId() {
		return customerId;
	}

	public void setCustomerId(List<Integer> customerId) {
		this.customerId = customerId;
	}
}
