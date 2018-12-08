package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.SystemMarkItem;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserSideSettingApi extends AbstractUserSideClient {
	public UserSideSettingApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideSettingApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public List<SystemMarkItem> getSystemMarkList() throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "setting"));
		params.add(new BasicNameValuePair("action", "mark_show"));
		return executeIndexEncapsulatedRequest(SystemMarkItem.class, params);
	}

	public Integer addSystemMark(@NotNull String name, String[] type_array) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "setting"));
		params.add(new BasicNameValuePair("action", "mark_add"));
		params.add(new BasicNameValuePair("name", name));
		for (String type : type_array) {
			params.add(new BasicNameValuePair("type_array[]", type));
		}
		return executeIdRequest(params);

	}
}
