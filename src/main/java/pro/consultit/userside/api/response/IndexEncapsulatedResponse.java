package pro.consultit.userside.api.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

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

	@JsonSetter(contentNulls = Nulls.AS_EMPTY, nulls = Nulls.AS_EMPTY)
	public void setData(Map<I, T> data) {
		this.data = data;
	}
}
