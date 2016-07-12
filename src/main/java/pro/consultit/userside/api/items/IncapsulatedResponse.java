package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncapsulatedResponse {

	public class UserSideIncapsulatedResponse<T> {

		@JsonProperty("Result")
		private String result;
		@JsonProperty("Error")
		private String error;

		private T data;

		protected UserSideIncapsulatedResponse() {
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

		public UserSideIncapsulatedResponse setError(String error) {
			this.error = error;
			return this;
		}
	}

}
