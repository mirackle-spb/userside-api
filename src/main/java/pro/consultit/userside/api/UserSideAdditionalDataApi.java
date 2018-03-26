package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import pro.consultit.userside.api.items.AdditionalParam;
import pro.consultit.userside.api.items.IndexEncapsulatedResponse;

import java.io.IOException;

public class UserSideAdditionalDataApi extends UserSideAddressApi {

	public UserSideAdditionalDataApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideAdditionalDataApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public IndexEncapsulatedResponse<Integer, AdditionalParam> getHouseAdditionalParameterList() throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=additional_data&action=get_list&section=house");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, AdditionalParam>>() {
		});
	}

	public IndexEncapsulatedResponse<Integer, AdditionalParam> getDeviceAdditionalParameterList() throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=additional_data&action=get_list&section=switch");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, AdditionalParam>>() {
		});
	}
}
