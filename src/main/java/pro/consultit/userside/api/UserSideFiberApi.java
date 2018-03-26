package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserSideFiberApi extends AbstractUserSideClient {
	public UserSideFiberApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideFiberApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}
}
