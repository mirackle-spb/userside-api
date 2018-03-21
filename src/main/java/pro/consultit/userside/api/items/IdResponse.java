package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdResponse {
	@JsonProperty("Result")
	private String result;
	@JsonProperty("Id")
	private Integer resultId;

	protected IdResponse() {
	}

	public IdResponse(String result, Integer resultId) {
		this.result = result;
		this.resultId = resultId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}
}
