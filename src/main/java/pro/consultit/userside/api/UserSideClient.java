package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import pro.consultit.userside.api.items.*;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSideClient {

	private String url;
	private String key;
	private ObjectMapper objectMapper;
	private HttpClient httpclient = new DefaultHttpClient();
	private URLCodec urlCodec = new URLCodec();

	public UserSideClient(ObjectMapper objectMapper, String url, String key) {
		this.objectMapper = objectMapper;
		this.url = url;
		this.key = key;
	}

	public Map<Integer, CityListItem> getCityList() throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=module&request=get_city_list");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<HashMap<Integer, CityListItem>>() {
		});
	}

	public Map<Integer, DistrictListItem> getDistrictList() throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=module&request=get_city_district_list");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<HashMap<Integer, DistrictListItem>>() {
		});
	}

	public Map<Integer, StreetListItem> getStreetList() throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=module&request=get_street_list");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<HashMap<Integer, StreetListItem>>() {
		});
	}

	public IndexIncapsulatedResponse<Integer, HouseListItem> getHouseList() throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=address&action=get_house");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexIncapsulatedResponse<Integer, HouseListItem>>() {
		});
	}

	public IndexIncapsulatedResponse<Integer, HouseListItem> getHouse(int houseId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=address&action=get_house&id=" + houseId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexIncapsulatedResponse<Integer, HouseListItem>>() {
		});
	}

	public IndexIncapsulatedResponse<Integer, AdditionalParam> getHouseAdditionalParameterList() throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=additional_data&action=get_list&section=house");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexIncapsulatedResponse<Integer, AdditionalParam>>() {
		});
	}

	public IndexIncapsulatedResponse<Integer, AdditionalParam> getDeviceAdditionalParameterList() throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=additional_data&action=get_list&section=switch");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexIncapsulatedResponse<Integer, AdditionalParam>>() {
		});
	}

	public IndexIncapsulatedResponse<Integer, OperatorResponse> getOperator(int operatorId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=operator&action=get&id=" + operatorId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexIncapsulatedResponse<Integer, OperatorResponse>>() {
		});
	}

	public IndexIncapsulatedResponse<Integer, DeviceListItem> getDevice(int deviceId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=device&action=get_data&object_type=switch&object_id=" + deviceId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexIncapsulatedResponse<Integer, DeviceListItem>>() {
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

	public IncapsulatedResponse<Map<Integer, CommutationListItem[]>> getCommutationList(int deviceId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=commutation&action=get_data&object_type=switch&is_finish_data=1&object_id=" + deviceId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IncapsulatedResponse<Map<Integer, Map<String, CommutationListItem>>> usResponse = objectMapper.readValue(entity.getContent(), new TypeReference<IncapsulatedResponse<Map<Integer, Map<String, CommutationListItem>>>>() {
		});
		Map<Integer, CommutationListItem[]> resultMap = new HashMap<>();
		if (usResponse.getData() != null) {
			for (Integer port : usResponse.getData().keySet()) {
				if (usResponse.getData().get(port).containsKey("finish")) {
					resultMap.put(port, new CommutationListItem[]{usResponse.getData().get(port).get("finish")});
				}
			}
		}
		return new IncapsulatedResponse<>(usResponse.getResult(), usResponse.getError(), resultMap);
	}

	public IndexIncapsulatedResponse<Integer, SystemMarkItem> getSystemMarkList() throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=setting&action=mark_show");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexIncapsulatedResponse<Integer, SystemMarkItem>>() {
		});
	}

	public ActionResponse<Integer> addSystemMark(String name, String[] type_array) throws IOException, EncoderException {
		String getString = url + "?key=" + key + "&cat=setting&action=mark_add&name=" + urlCodec.encode(name);
		for (String type : type_array) {
			getString += "&type_array[]=" + urlCodec.encode(type);
		}
		HttpGet httpget = new HttpGet(getString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<ActionResponse<Integer>>() {
		});
	}


	/**
	 * Looking for item inventory category identifier by item name
	 *
	 * @param name Item name to find
	 * @return id of US category or null if not found
	 * @throws IOException
	 * @throws EncoderException
	 */
	public Integer getCatalogId(String name) throws IOException, EncoderException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=inventory&action=get_inventory_catalog_id_by_name&name=" + urlCodec.encode(name));
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		Map<String, String> result = objectMapper.readValue(entity.getContent(), new TypeReference<HashMap<String, String>>() {
		});
		if (result.get("id") != null) {
			return Integer.parseInt(result.get("id"));
		} else {
			return null;
		}
	}

	/**
	 * Looking for item inventory id by asset number
	 *
	 * @param assetNumber asset number
	 * @return id of inventory item or null if not found
	 * @throws IOException
	 * @throws EncoderException
	 */

	public Integer getInventoryId(String assetNumber) throws IOException, EncoderException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=inventory&action=get_inventory_id&data_typer=inventory_number&data_value=" + urlCodec.encode(assetNumber));
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		Map<String, String> result = objectMapper.readValue(entity.getContent(), new TypeReference<HashMap<String, String>>() {
		});
		if (result.get("id") != null) {
			return Integer.parseInt(result.get("id"));
		} else {
			return null;
		}
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
		if (result.get("id") != null) {
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
		if (result.get("id") != null) {
			return Integer.parseInt(result.get("id"));
		} else {
			return null;
		}
	}

	/**
	 * Looking for item inventory id by asset number
	 *
	 * @param inventoryId inventoryId
	 * @return id of inventory item or null if not found
	 * @throws IOException
	 * @throws EncoderException
	 */

	public IncapsulatedResponse<InventoryListItem> getInventoryById(int inventoryId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=inventory&action=get_inventory&id=" + inventoryId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IncapsulatedResponse<InventoryListItem>>() {
		});
	}

	public List<Integer> addInventory(int catalogId, int traderId, int amount, double cost, int storageId, String serial, String assetNumber) throws IOException {
		HttpGet httpget = new HttpGet(url);
		BasicHttpParams params = new BasicHttpParams();
		params.setParameter("key", key);
		params.setParameter("cat", "inventory");
		params.setParameter("action", "add_inventory");
		params.setParameter("inventory_catalog_id", catalogId);
		params.setParameter("trader_id", traderId);
		params.setParameter("amount", amount);
		params.setParameter("cost", cost);
		params.setParameter("storage_id", storageId);
		params.setParameter("sn", serial);
		params.setParameter("inventory_number", assetNumber);
		httpget.setParams(params);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<List<Integer>>() {
		});
	}

	public Integer inventoryTransfer(int inventoryId, String dstAccount) throws IOException {
		HttpGet httpget = new HttpGet(url);
		BasicHttpParams params = new BasicHttpParams();
		params.setParameter("key", key);
		params.setParameter("cat", "inventory");
		params.setParameter("action", "transfer_inventory");
		params.setParameter("inventory_id", inventoryId);
		params.setParameter("dst_account", dstAccount);
		httpget.setParams(params);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		List<Integer> result = objectMapper.readValue(entity.getContent(), new TypeReference<List<Integer>>() {
		});
		return result.size() > 0 ? result.get(0) : null;
	}

	public Integer getCustomerByBillingId(int billingId) throws IOException {
		HttpGet httpget = new HttpGet(url);
		BasicHttpParams params = new BasicHttpParams();
		params.setParameter("key", key);
		params.setParameter("cat", "customer");
		params.setParameter("subcat", "get_abon_id");
		params.setParameter("data_typer", "billing_uid");
		params.setParameter("data_value", billingId);
		httpget.setParams(params);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getCustomerId() != null) {
			return result.getCustomerId();
		} else {
			return null;
		}
	}

	public Integer addTask(int taskType, @NotNull Date dateToDo, int customerId, String description) throws IOException {
		HttpGet httpget = new HttpGet(url);
		BasicHttpParams params = new BasicHttpParams();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		params.setParameter("key", key);
		params.setParameter("cat", "task");
		params.setParameter("subcat", "add");
		params.setParameter("work_typer", taskType);
		params.setParameter("work_datedo", dateFormat.format(dateToDo));
		params.setParameter("usercode", customerId);
		if (description != null) {
			params.setParameter("opis", description);
		}
		httpget.setParams(params);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getCustomerId() != null) {
			return result.getCustomerId();
		} else {
			return null;
		}
	}
}
