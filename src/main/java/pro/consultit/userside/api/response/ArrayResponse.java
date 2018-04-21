package pro.consultit.userside.api.response;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.ArrayList;
import java.util.List;

public class ArrayResponse<T> extends DefaultResponse {

	@JsonAlias({"data", "Data"})
	private List<T> data = new ArrayList<>();

	protected ArrayResponse() {
	}

	public ArrayResponse(String result, String error) {
		super(result, error);
	}

	public List<T> getData() {
		return data;
	}
}
