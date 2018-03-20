package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EncapsulatedResponse<T> {

	@JsonProperty("Result")
	private String result;
	@JsonProperty("Error")
	private String error;
	@JsonAlias({"data", "Data"})
	private T data;

	protected EncapsulatedResponse() {
	}

	public EncapsulatedResponse(String result, String error, T data) {
		this.result = result;
		this.error = error;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public EncapsulatedResponse setError(String error) {
		this.error = error;
		return this;
	}
}

