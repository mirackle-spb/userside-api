package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionResponse<T> {
	@JsonProperty("Result")
	private String result;
	@JsonProperty("Error")
	private String error;

	private T id;

	protected ActionResponse() {
	}

	public String getResult() {
		return result;
	}

	public ActionResponse setResult(String result) {
		this.result = result;
		return this;
	}

	public String getError() {
		return error;
	}

	public ActionResponse setError(String error) {
		this.error = error;
		return this;
	}

	public T getId() {
		return id;
	}

	public ActionResponse setId(T id) {
		this.id = id;
		return this;
	}
}
