package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.EncoderException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import pro.consultit.userside.api.items.ActionResponse;
import pro.consultit.userside.api.items.IndexEncapsulatedResponse;
import pro.consultit.userside.api.items.SystemMarkItem;

import java.io.IOException;

public class UserSideSettingApi extends AbstractUserSideClient {
	public UserSideSettingApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideSettingApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public IndexEncapsulatedResponse<Integer, SystemMarkItem> getSystemMarkList() throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=setting&action=mark_show");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, SystemMarkItem>>() {
		});
	}

	public ActionResponse<Integer> addSystemMark(String name, String[] type_array) throws IOException, EncoderException {
		StringBuilder getString = new StringBuilder(url + "?key=" + key + "&cat=setting&action=mark_add&name=" + urlCodec.encode(name));
		for (String type : type_array) {
			getString.append("&type_array[]=").append(urlCodec.encode(type));
		}
		HttpGet httpget = new HttpGet(getString.toString());
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<ActionResponse<Integer>>() {
		});
	}
}
