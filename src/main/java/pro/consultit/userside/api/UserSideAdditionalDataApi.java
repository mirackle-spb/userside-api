package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.AdditionalParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserSideAdditionalDataApi extends UserSideAddressApi {

	public UserSideAdditionalDataApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideAdditionalDataApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public List<AdditionalParam> getHouseAdditionalParameterList() throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "additional_data"));
		params.add(new BasicNameValuePair("action", "get_list"));
		params.add(new BasicNameValuePair("section", "house"));
		return executeIndexEncapsulatedRequest(AdditionalParam.class, params);
	}

	public List<AdditionalParam> getDeviceAdditionalParameterList() throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "additional_data"));
		params.add(new BasicNameValuePair("action", "get_list"));
		params.add(new BasicNameValuePair("section", "switch"));

		return executeIndexEncapsulatedRequest(AdditionalParam.class, params);

	}
}
