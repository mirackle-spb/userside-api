package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.DeviceListItem;
import pro.consultit.userside.api.items.OntDataItem;
import pro.consultit.userside.api.items.device.DeviceFdbRecord;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserSideDeviceApi extends AbstractUserSideClient {
	public UserSideDeviceApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideDeviceApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public List<DeviceListItem> getDevice(Integer deviceId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "device"));
		params.add(new BasicNameValuePair("action", "get_data"));
		params.add(new BasicNameValuePair("object_type", "switch"));
		if (deviceId != null) {
			params.add(new BasicNameValuePair("object_id", String.valueOf(deviceId)));
		}
		return executeIndexEncapsulatedRequest(DeviceListItem.class, params);
	}

	public List<DeviceListItem> getOnlineDeviceList() throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "device"));
		params.add(new BasicNameValuePair("action", "get_data"));
		params.add(new BasicNameValuePair("object_type", "switch"));
		params.add(new BasicNameValuePair("is_online", "1"));
		params.add(new BasicNameValuePair("is_hide_ifaces_data", "1"));
		return executeIndexEncapsulatedRequest(DeviceListItem.class, params);
	}

	public List<DeviceFdbRecord> getDeviceFdb(Integer deviceId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "device"));
		params.add(new BasicNameValuePair("action", "read_fdb"));
		params.add(new BasicNameValuePair("device_id", deviceId.toString()));
		return executeArrayRequest(DeviceFdbRecord.class, params);
	}

	public OntDataItem getOntData(String lookupKey) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "device"));
		params.add(new BasicNameValuePair("action", "get_ont_data"));
		params.add(new BasicNameValuePair("id", lookupKey));
		return executeEncapsulatedRequest(OntDataItem.class, params);
	}

	public boolean appendDeviceMark(@NotNull Integer deviceId, @NotNull Integer markId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "device"));
		params.add(new BasicNameValuePair("action", "add_mark"));
		params.add(new BasicNameValuePair("object_type", "switch"));

		params.add(new BasicNameValuePair("object_id", String.valueOf(deviceId)));
		params.add(new BasicNameValuePair("mark_id", String.valueOf(markId)));
		return executeBooleanRequest(params);
	}

	public boolean deleteDeviceMark(int deviceId, int markId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "device"));
		params.add(new BasicNameValuePair("action", "delete_mark"));
		params.add(new BasicNameValuePair("object_type", "switch"));

		params.add(new BasicNameValuePair("object_id", String.valueOf(deviceId)));
		params.add(new BasicNameValuePair("mark_id", String.valueOf(markId)));

		return executeBooleanRequest(params);
	}

	/**
	 * Looking for device id by asset number
	 *
	 * @param assetNumber asset number
	 * @return id of devoce item or null if not found
	 * @throws IOException
	 * @throws UserSideApiErrorException
	 */

	public Integer getDeviceId(String assetNumber) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "device"));
		params.add(new BasicNameValuePair("action", "get_device_id"));
		params.add(new BasicNameValuePair("object_type", "switch"));
		params.add(new BasicNameValuePair("data_typer", "inventory_number"));
		params.add(new BasicNameValuePair("data_value", assetNumber));
		return executeIdRequest(params);
	}

	/**
	 * Looking for device id by device ip address
	 *
	 * @param ipAddress ip address
	 * @return id of devoce item or null if not found
	 * @throws IOException
	 * @throws UserSideApiErrorException
	 */

	public Integer getDeviceIdByIpAddress(@NotNull String ipAddress) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "device"));
		params.add(new BasicNameValuePair("action", "get_device_id"));
		params.add(new BasicNameValuePair("object_type", "switch"));
		params.add(new BasicNameValuePair("data_typer", "ip"));
		params.add(new BasicNameValuePair("data_value", ipAddress));
		return executeIdRequest(params);

	}
}
