package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import pro.consultit.userside.api.items.*;
import pro.consultit.userside.api.items.customer.CustomerData;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserSideClient {

	private String url;
	private String key;
	private ObjectMapper objectMapper;
	private HttpClient httpclient = new DefaultHttpClient();
	private URLCodec urlCodec = new URLCodec();
	private int timeout = 5;

	public UserSideClient(ObjectMapper objectMapper, String url, String key) {
		this.objectMapper = objectMapper;
		this.url = url;
		this.key = key;
		setHttpClientTimeout(httpclient);
	}

	public UserSideClient(ObjectMapper objectMapper, String url, String key, int timeout) {
		this.objectMapper = objectMapper;
		this.url = url;
		this.key = key;
		this.timeout = timeout;
		setHttpClientTimeout(httpclient);
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

	@Deprecated
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

	public IncapsulatedResponse<Map<Integer, CommutationListItem[]>> getCommutationList(CommutaionType type, int objectId) throws IOException {
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
			case CUSTOMER:
				params.add(new BasicNameValuePair("object_type", "customer"));
				break;
		}
		params.add(new BasicNameValuePair("is_finish_data", "1"));
		params.add(new BasicNameValuePair("object_id", String.valueOf(objectId)));

		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

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
		if (result.get("Result") != null && result.get("Result").equals("OK")) {
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
		if (result.get("Result") != null && result.get("Result").equals("OK")) {
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

	public Integer addInventory(int catalogId, int traderId, int amount, double cost, int storageId, String serial, String assetNumber) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "inventory"));
		params.add(new BasicNameValuePair("action", "add_inventory"));
		params.add(new BasicNameValuePair("inventory_catalog_id", String.valueOf(catalogId)));
		params.add(new BasicNameValuePair("trader_id", String.valueOf(traderId)));
		params.add(new BasicNameValuePair("amount", String.valueOf(amount)));
		params.add(new BasicNameValuePair("cost", String.valueOf(cost)));
		params.add(new BasicNameValuePair("storage_id", String.valueOf(storageId)));
		params.add(new BasicNameValuePair("sn", serial));
		params.add(new BasicNameValuePair("inventory_number", assetNumber));

		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		Map<String, String> result = objectMapper.readValue(entity.getContent(), new TypeReference<Map<String, String>>() {
		});
		if (result.get("Result") != null && result.get("Result").equals("OK")) {
			return Integer.parseInt(result.get("id"));
		} else {
			return null;
		}
	}

	public Integer inventoryTransfer(int inventoryId, String dstAccount) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "inventory"));
		params.add(new BasicNameValuePair("action", "transfer_inventory"));
		params.add(new BasicNameValuePair("inventory_id", String.valueOf(inventoryId)));
		params.add(new BasicNameValuePair("dst_account", String.valueOf(dstAccount)));

		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		Map<String, String> result = objectMapper.readValue(entity.getContent(), new TypeReference<Map<String, String>>() {
		});
		if (result.get("Result") != null && result.get("Result").equals("OK")) {
			return Integer.parseInt(result.get("id"));
		} else {
			return null;
		}
	}

	public Integer getCustomerByBillingId(int billingId) throws IOException {

		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "get_abon_id"));
		params.add(new BasicNameValuePair("data_typer", "billing_uid"));
		params.add(new BasicNameValuePair("data_value", String.valueOf(billingId)));

		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

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

	public List<Integer> getCustomerByPhone(String customerPhone) throws IOException {

		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "get_abon_id"));
		params.add(new BasicNameValuePair("data_typer", "phone"));
		params.add(new BasicNameValuePair("data_value", customerPhone));

		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IdArrayResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdArrayResponse>() {
		});
		if (result.getResult().equals("OK") && result.getCustomerId().size() > 0) {
			return result.getCustomerId();
		} else {
			return null;
		}
	}

	public CustomerData getCustomerData(int customerId) throws IOException {

		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "get_data"));
		params.add(new BasicNameValuePair("customer_id", Integer.toString(customerId)));

		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		IncapsulatedResponse<CustomerData> result = objectMapper.readValue(entity.getContent(), new TypeReference<IncapsulatedResponse<CustomerData>>() {
		});
		if (result.getResult().equals("OK") && result.getData() != null) {
			return result.getData();
		} else {
			return null;
		}
	}


	public Integer addTask(int taskType, @NotNull Date dateToDo, int customerId, String description) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("subcat", "add"));
		params.add(new BasicNameValuePair("work_typer", String.valueOf(taskType)));
		params.add(new BasicNameValuePair("work_datedo", dateFormat.format(dateToDo)));
		params.add(new BasicNameValuePair("usercode", String.valueOf(customerId)));
		if (description != null) {
			params.add(new BasicNameValuePair("opis", description));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getCustomerId() != null) {
			return result.getCustomerId();
		} else {
			return null;
		}
	}

	public Integer addTaskComment(int taskId, String description) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("subcat", "comment_add"));
		params.add(new BasicNameValuePair("id", String.valueOf(taskId)));
		if (description != null) {
			params.add(new BasicNameValuePair("comment", description));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getCustomerId() != null) {
			return result.getCustomerId();
		} else {
			return null;
		}
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	private void setHttpClientTimeout(HttpClient httpClient) {
		HttpParams httpParams = httpClient.getParams();
		httpParams.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout * 1000);
		httpParams.setParameter(CoreConnectionPNames.SO_TIMEOUT, timeout * 1000);
	}

	public enum CommutaionType {
		CUSTOMER, SWITCH, CROSS, FIBER
	}
}
