package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class IndexIncapsulatedResponse<I, T> {
	@JsonProperty("Result")
	private String result;
	@JsonProperty("Error")
	private String error;

	private Map<I, T> data = new HashMap();

	protected IndexIncapsulatedResponse() {
	}

	public String getResult() {
		return result;
	}

	public IndexIncapsulatedResponse setResult(String result) {
		this.result = result;
		return this;
	}

	public String getError() {
		return error;
	}

	public IndexIncapsulatedResponse setError(String error) {
		this.error = error;
		return this;
	}

	public Map<I, T> getData() {
		return data;
	}

	public void setData(Map<I, T> data) {
		this.data = data;
	}
}
