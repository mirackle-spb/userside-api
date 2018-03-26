package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.EncoderException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import pro.consultit.userside.api.items.ActionResponse;
import pro.consultit.userside.api.items.DeviceListItem;
import pro.consultit.userside.api.items.IndexEncapsulatedResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserSideDeviceApi extends AbstractUserSideClient {
	public UserSideDeviceApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideDeviceApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public IndexEncapsulatedResponse<Integer, DeviceListItem> getDevice(int deviceId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=device&action=get_data&object_type=switch&object_id=" + deviceId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, DeviceListItem>>() {
		});
	}

	public boolean appendDeviceMark(int deviceId, int markId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=device&action=add_mark&object_type=switch&object_id=" + deviceId + "&mark_id=" + markId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		ActionResponse<Integer> usResponse = objectMapper.readValue(entity.getContent(), new TypeReference<ActionResponse<Integer>>() {
		});
		return usResponse.getResult() != null && usResponse.getResult().equals("OK");
	}

	public boolean deleteDeviceMark(int deviceId, int markId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=device&action=delete_mark&object_type=switch&object_id=" + deviceId + "&mark_id=" + markId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		ActionResponse<Integer> usResponse = objectMapper.readValue(entity.getContent(), new TypeReference<ActionResponse<Integer>>() {
		});
		return usResponse.getResult() != null && usResponse.getResult().equals("OK");
	}

	/**
	 * Looking for device id by asset number
	 *
	 * @param assetNumber asset number
	 * @return id of devoce item or null if not found
	 * @throws IOException
	 * @throws EncoderException
	 */

	public Integer getDeviceId(String assetNumber) throws IOException, EncoderException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=device&action=get_device_id&object_type=switch&data_typer=inventory_number&data_value=" + urlCodec.encode(assetNumber));
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		Map<String, String> result = objectMapper.readValue(entity.getContent(), new TypeReference<HashMap<String, String>>() {
		});
		if (result.get("Result") != null && result.get("Result").equals("OK")) {
			return Integer.parseInt(result.get("id"));
		} else {
			return null;
		}
	}

	/**
	 * Looking for device id by device ip address
	 *
	 * @param ipAddress ip address
	 * @return id of devoce item or null if not found
	 * @throws IOException
	 * @throws EncoderException
	 */

	public Integer getDeviceIdByIpAddress(String ipAddress) throws IOException, EncoderException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=device&action=get_device_id&object_type=switch&data_typer=ip&data_value=" + urlCodec.encode(ipAddress));
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		Map<String, String> result = objectMapper.readValue(entity.getContent(), new TypeReference<HashMap<String, String>>() {
		});
		if (result.get("Result") != null && result.get("Result").equals("OK")) {
			return Integer.parseInt(result.get("id"));
		} else {
			return null;
		}
	}
}
