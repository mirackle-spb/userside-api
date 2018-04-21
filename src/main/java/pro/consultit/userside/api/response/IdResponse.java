package pro.consultit.userside.api.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdResponse extends DefaultResponse {

	@JsonAlias({"id", "Id"})
	private Integer resultId;

	protected IdResponse() {
		super();
	}

	public IdResponse(String result, String error, Integer resultId) {
		super(result, error);
		this.resultId = resultId;
	}

	public Integer getResultId() {
		return resultId;
	}

	public IdResponse setResultId(Integer resultId) {
		this.resultId = resultId;
		return this;
	}
}
