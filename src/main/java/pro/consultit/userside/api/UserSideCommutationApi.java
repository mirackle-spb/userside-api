package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.CommutationListItem;
import pro.consultit.userside.api.response.EncapsulatedResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSideCommutationApi extends AbstractUserSideClient {
	public UserSideCommutationApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideCommutationApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	@Deprecated
	public EncapsulatedResponse<Map<Integer, CommutationListItem[]>> getCommutationList(int deviceId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=commutation&action=get_data&object_type=switch&is_finish_data=1&object_id=" + deviceId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		EncapsulatedResponse<Map<Integer, Map<String, CommutationListItem>>> usResponse = objectMapper.readValue(entity.getContent(), new TypeReference<EncapsulatedResponse<Map<Integer, Map<String, CommutationListItem>>>>() {
		});
		Map<Integer, CommutationListItem[]> resultMap = new HashMap<>();
		if (usResponse.getData() != null) {
			for (Integer port : usResponse.getData().keySet()) {
				if (usResponse.getData().get(port).containsKey("finish")) {
					resultMap.put(port, new CommutationListItem[]{usResponse.getData().get(port).get("finish")});
				}
			}
		}
		EncapsulatedResponse<Map<Integer, CommutationListItem[]>> methodResponse = new EncapsulatedResponse<>(usResponse.getResult(), usResponse.getError());
		methodResponse.getData().putAll(resultMap);
		return methodResponse;
	}
	/*
	DO NOT USE WITH CommutaionType=CUSTOMER
	 */

	public EncapsulatedResponse<Map<Integer, CommutationListItem[]>> getCommutationList(CommutaionType type, int objectId) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "commutation"));
		params.add(new BasicNameValuePair("action", "get_data"));
		switch (type) {
			case CROSS:
				params.add(new BasicNameValuePair("object_type", "cross"));
				break;
			case FIBER:
				params.add(new BasicNameValuePair("object_type", "fiber"));
				break;
			case SWITCH:
				params.add(new BasicNameValuePair("object_type", "switch"));
				break;
			default:
				throw new IOException("DO NOT USE WITH CommutaionType=" + type.toString());
		}
		params.add(new BasicNameValuePair("object_id", String.valueOf(objectId)));
		params.add(new BasicNameValuePair("is_finish_data", "1"));

		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		EncapsulatedResponse<Map<Integer, Map<String, CommutationListItem>>> usResponse = objectMapper.readValue(entity.getContent(), new TypeReference<EncapsulatedResponse<Map<Integer, Map<String, CommutationListItem>>>>() {
		});
		Map<Integer, CommutationListItem[]> resultMap = new HashMap<>();
		if (usResponse.getData() != null) {
			for (Integer port : usResponse.getData().keySet()) {
				if (usResponse.getData().get(port).containsKey("finish")) {
					resultMap.put(port, new CommutationListItem[]{usResponse.getData().get(port).get("finish")});
				}
			}
		}
		EncapsulatedResponse<Map<Integer, CommutationListItem[]>> methodResponse = new EncapsulatedResponse<>(usResponse.getResult(), usResponse.getError());
		methodResponse.setData(resultMap);
		return methodResponse;
	}

	public List<CommutationListItem> getCustomerCommutationList(int customerId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "commutation"));
		params.add(new BasicNameValuePair("action", "get_data"));
		params.add(new BasicNameValuePair("object_type", "customer"));
		params.add(new BasicNameValuePair("object_id", String.valueOf(customerId)));
		params.add(new BasicNameValuePair("is_finish_data", "1"));

		return executeIndexEncapsulatedRequest(CommutationListItem.class, params);

	}

}
