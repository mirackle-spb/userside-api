package pro.consultit.userside.api.response;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

	public void setData(Object data) {
		if (data instanceof Map) {
			this.data = (Map<I, T>) data;
		} else if (data instanceof List && ((List) data).size() == 0) {
			this.data = Collections.EMPTY_MAP;
		} else {
			throw new IllegalArgumentException("Invalid value: " + data);
		}
	}
}
