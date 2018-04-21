package pro.consultit.userside.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultResponse {
	@JsonProperty("Result")
	private String result;
	@JsonProperty("ErrorText")
	private String error;

	protected DefaultResponse() {
	}

	public DefaultResponse(String result, String error) {
		this.result = result;
		this.error = error;
	}

	public String getResult() {
		return result;
	}

	public DefaultResponse setResult(String result) {
		this.result = result;
		return this;
	}

	public String getError() {
		return error;
	}

	public DefaultResponse setError(String error) {
		this.error = error;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DefaultResponse)) return false;

		DefaultResponse that = (DefaultResponse) o;

		if (getResult() != null ? !getResult().equals(that.getResult()) : that.getResult() != null) return false;
		return getError() != null ? getError().equals(that.getError()) : that.getError() == null;
	}

	@Override
	public int hashCode() {
		int result1 = getResult() != null ? getResult().hashCode() : 0;
		result1 = 31 * result1 + (getError() != null ? getError().hashCode() : 0);
		return result1;
	}
}
