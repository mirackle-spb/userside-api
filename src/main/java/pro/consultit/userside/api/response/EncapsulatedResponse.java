package pro.consultit.userside.api.response;

import com.fasterxml.jackson.annotation.JsonAlias;

public class EncapsulatedResponse<T> extends DefaultResponse {

	@JsonAlias({"data", "Data"})
	private T data;

	protected EncapsulatedResponse() {
	}

	public EncapsulatedResponse(String result, String error) {
		super(result, error);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

