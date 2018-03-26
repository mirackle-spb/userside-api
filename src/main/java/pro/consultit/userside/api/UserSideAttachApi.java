package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserSideAttachApi extends AbstractUserSideClient {
	public UserSideAttachApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideAttachApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}
}
