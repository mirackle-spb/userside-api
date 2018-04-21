package pro.consultit.userside.api.response;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.HashMap;
import java.util.Map;

public class IndexEncapsulatedResponse<I, T> extends DefaultResponse {

	@JsonAlias({"data", "Data"})
	private Map<I, T> data = new HashMap<>();

	protected IndexEncapsulatedResponse() {
		super();
	}

	public IndexEncapsulatedResponse(String result, String error) {
		super(result, error);
	}

	public Map<I, T> getData() {
		return data;
	}

	public void setData(Map<I, T> data) {
		this.data = data;
	}
}
