package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.io.IOUtils;
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
import pro.consultit.userside.api.items.address.*;
import pro.consultit.userside.api.items.customer.CustomerData;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

	public Map<Integer, RegionItem> getRegionList() throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_province"));
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, RegionItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, RegionItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}

	public Map<Integer, RegionDistrictItem> getRegionDistrictList() throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_provinsadfce"));
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, RegionDistrictItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, RegionDistrictItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}

	public Map<Integer, CityItem> getCityList(Integer regionId) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_city"));
		if (regionId != null) {
			params.add(new BasicNameValuePair("province_id", regionId.toString()));
		}
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, CityItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, CityItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}

	public Map<Integer, CityDistrictItem> getCityDistrictList(Integer cityId) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_area"));
		if (cityId != null) {
			params.add(new BasicNameValuePair("city_id", cityId.toString()));
		}
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, CityDistrictItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, CityDistrictItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}

	public Map<Integer, StreetItem> getStreetList(@NotNull List<Integer> cityIdList, List<Integer> cityRegionIdList) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_street"));
		params.add(new BasicNameValuePair("city_id", String.join(",", cityIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		if (cityRegionIdList != null && cityRegionIdList.size() > 0) {
			params.add(new BasicNameValuePair("area_id", String.join(",", cityRegionIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, StreetItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, StreetItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}

	public Map<Integer, HouseItem> getHouse(List<Integer> cityIdList, List<Integer> cityRegionIdList, List<Integer> streetIdList) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_house"));
		if (cityIdList != null && cityIdList.size() > 0) {
			params.add(new BasicNameValuePair("city_id", String.join(",", cityIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		if (cityRegionIdList != null && cityRegionIdList.size() > 0) {
			params.add(new BasicNameValuePair("area_id", String.join(",", cityRegionIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		if (streetIdList != null && streetIdList.size() > 0) {
			params.add(new BasicNameValuePair("street_id", String.join(",", streetIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, HouseItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, HouseItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
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

	public IndexEncapsulatedResponse<Integer, OperatorResponse> getOperator(int operatorId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=operator&action=get&id=" + operatorId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, OperatorResponse>>() {
		});
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
		return new EncapsulatedResponse<>(usResponse.getResult(), usResponse.getError(), resultMap);
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
		return new EncapsulatedResponse<>(usResponse.getResult(), usResponse.getError(), resultMap);
	}

	public List<CommutationListItem> getCustomerCommutationList(int customerId) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "commutation"));
		params.add(new BasicNameValuePair("action", "get_data"));
		params.add(new BasicNameValuePair("object_type", "customer"));
		params.add(new BasicNameValuePair("object_id", String.valueOf(customerId)));
		params.add(new BasicNameValuePair("is_finish_data", "1"));

		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		EncapsulatedResponse<List<CommutationListItem>> usResponse = objectMapper.readValue(entity.getContent(), new TypeReference<EncapsulatedResponse<List<CommutationListItem>>>() {
		});
		if (!usResponse.getResult().equals("OK") || usResponse.getData().size() == 0) {
			return null;
		} else {
			return usResponse.getData();
		}
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
	 * Looking for item inventory category identifier by item name
	 *
	 * @return id of US category or null if not found
	 * @throws IOException
	 * @throws EncoderException
	 */
	public Map<Integer, InventoryCatalogItem> getInventoryCatalogList() throws IOException, EncoderException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=inventory&action=get_inventory_catalog");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, InventoryCatalogItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, InventoryCatalogItem>>() {
		});
		if (result.getResult() != null && result.getResult().equals("OK")) {
			return result.getData();
		} else {
			return null;
		}
	}

	/**
	 * Looking for item inventory category identifier by item name
	 *
	 * @return id of US category or null if not found
	 * @throws IOException
	 * @throws EncoderException
	 */
	public Map<Integer, InventoryCatalogSectionItem> getInventoryCatalogSectionList() throws IOException, EncoderException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=inventory&action=get_inventory_section_catalog");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, InventoryCatalogSectionItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, InventoryCatalogSectionItem>>() {
		});
		if (result.getResult() != null && result.getResult().equals("OK")) {
			return result.getData();
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

	public EncapsulatedResponse<InventoryListItem> getInventoryById(int inventoryId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=inventory&action=get_inventory&id=" + inventoryId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<EncapsulatedResponse<InventoryListItem>>() {
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
		if (result.getResult().equals("OK") && result.getResultId() != null) {
			return result.getResultId();
		} else {
			return null;
		}
	}

	public List<Integer> getCustomerByPhone(String customerPhone, boolean skipArchive) throws IOException {

		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "get_abon_id"));
		params.add(new BasicNameValuePair("data_typer", "phone"));
		params.add(new BasicNameValuePair("data_value", customerPhone));
		if (skipArchive) {
			params.add(new BasicNameValuePair("is_skip_old", "1"));
		} else {
			params.add(new BasicNameValuePair("is_skip_old", "0"));
		}

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

		EncapsulatedResponse<CustomerData> result = objectMapper.readValue(entity.getContent(), new TypeReference<EncapsulatedResponse<CustomerData>>() {
		});
		if (result.getResult().equals("OK") && result.getData() != null) {
			return result.getData();
		} else {
			return null;
		}
	}


	public Integer addCustomerTask(int taskType, @NotNull Date dateToDo, @NotNull Integer customerId, String description) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("subcat", "add"));
		params.add(new BasicNameValuePair("work_typer", String.valueOf(taskType)));
		params.add(new BasicNameValuePair("work_datedo", dateFormat.format(dateToDo)));
		if (customerId != null) {
			params.add(new BasicNameValuePair("usercode", String.valueOf(customerId)));
		}
		if (description != null) {
			params.add(new BasicNameValuePair("opis", description));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getResultId() != null) {
			return result.getResultId();
		} else {
			return null;
		}
	}

	@Deprecated
	public Integer addHouseTask(int taskType, @NotNull Date dateToDo, Integer houseCodeId, String description) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("subcat", "add"));
		params.add(new BasicNameValuePair("work_typer", String.valueOf(taskType)));
		params.add(new BasicNameValuePair("work_datedo", dateFormat.format(dateToDo)));
		if (houseCodeId != null) {
			params.add(new BasicNameValuePair("housecode", String.valueOf(houseCodeId)));
		}
		if (description != null) {
			params.add(new BasicNameValuePair("opis", description));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getResultId() != null) {
			return result.getResultId();
		} else {
			return null;
		}
	}

	public Integer addHouseTask(int taskType, @NotNull Date dateToDo, String clientFullname, Integer cityCodeId, Integer houseCodeId, Integer apartmentNumber, String description) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("subcat", "add"));
		params.add(new BasicNameValuePair("work_typer", String.valueOf(taskType)));
		params.add(new BasicNameValuePair("work_datedo", dateFormat.format(dateToDo)));
		if (cityCodeId != null) {
			params.add(new BasicNameValuePair("citycode", String.valueOf(cityCodeId)));
		}
		if (houseCodeId != null) {
			params.add(new BasicNameValuePair("housecode", String.valueOf(houseCodeId)));
		}
		if (apartmentNumber != null) {
			params.add(new BasicNameValuePair("apart", String.valueOf(apartmentNumber)));
		}
		if (clientFullname != null) {
			params.add(new BasicNameValuePair("fio", clientFullname));
		}
		if (description != null) {
			params.add(new BasicNameValuePair("opis", description));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getResultId() != null) {
			return result.getResultId();
		} else {
			return null;
		}
	}

	public Integer addClient(@NotNull String clientFullname, Integer clientBillingId, Integer billingId, Boolean isPotential) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "add"));
		params.add(new BasicNameValuePair("fio", clientFullname));
		if (clientBillingId != null && billingId != null) {
			params.add(new BasicNameValuePair("codeti", String.valueOf(clientBillingId)));
			params.add(new BasicNameValuePair("billing_id", String.valueOf(billingId)));
		}
		if (isPotential != null) {
			params.add(new BasicNameValuePair("is_potential", String.valueOf(isPotential)));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getResultId() != null) {
			return result.getResultId();
		} else {
			return null;
		}
	}

	public boolean editClient(@NotNull Integer clientId, String clientFullname,
	                          String agreementNumber, Date agreementDate,
	                          Integer apartmentNumber, String email,
	                          Integer floor, Integer houseId, String login,
	                          String phone0, String phone1, Boolean isPotential) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "edit"));
		params.add(new BasicNameValuePair("id", String.valueOf(clientId)));
		if (clientFullname != null) {
			params.add(new BasicNameValuePair("name", clientFullname));
		}
		if (agreementNumber != null && agreementDate != null) {
			params.add(new BasicNameValuePair("agreement_number", String.valueOf(agreementNumber)));
			params.add(new BasicNameValuePair("agreement_date", String.valueOf(agreementDate)));
		}
		if (email != null) {
			params.add(new BasicNameValuePair("email", email));
		}
		if (houseId != null) {
			params.add(new BasicNameValuePair("house_id", String.valueOf(houseId)));
		}
		if (apartmentNumber != null) {
			params.add(new BasicNameValuePair("apartment_number", String.valueOf(apartmentNumber)));
		}
		if (floor != null) {
			params.add(new BasicNameValuePair("floor", String.valueOf(floor)));
		}
		if (login != null) {
			params.add(new BasicNameValuePair("login", login));
		}
		if (phone0 != null) {
			params.add(new BasicNameValuePair("phone0", phone0));
		}
		if (phone1 != null) {
			params.add(new BasicNameValuePair("phone1", phone1));
		}
		if (isPotential != null) {
			params.add(new BasicNameValuePair("is_potential", String.valueOf(isPotential)));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		String responseBody = IOUtils.toString(entity.getContent(), "UTF-8");
		return response.getStatusLine().getStatusCode() == 200;
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
		if (result.getResult().equals("OK") && result.getResultId() != null) {
			return result.getResultId();
		} else {
			return null;
		}
	}

	public boolean doLogin(String username, String password) {
		String fingerprint = DigestUtils.md5Hex(password);
		HttpGet httpget = null;
		HttpEntity entity = null;
		EncapsulatedResponse<String> incResponse = null;
		try {
			httpget = new HttpGet(url + "?key=" + key + "&cat=operator&action=check_pass&login=" + urlCodec.encode(username) + "&pass=" + urlCodec.encode(fingerprint));
			HttpResponse response = httpclient.execute(httpget);
			entity = response.getEntity();
			incResponse = objectMapper.readValue(entity.getContent(), new TypeReference<EncapsulatedResponse<String>>() {
			});
		} catch (EncoderException | IOException e) {
			return false;
		}
		return incResponse != null && incResponse.getResult() != null && incResponse.getResult().equalsIgnoreCase("ok");

	}

	public boolean checkTaskVerifyCode(int taskId, String code) {
		HttpGet httpget = null;
		HttpEntity entity = null;
		EncapsulatedResponse<String> incResponse = null;
		try {
			httpget = new HttpGet(url + "?key=" + key + "&cat=task&action=check_verify_code&id=" + taskId + "&verify_code=" + urlCodec.encode(code));
			HttpResponse response = httpclient.execute(httpget);
			entity = response.getEntity();
			incResponse = objectMapper.readValue(entity.getContent(), new TypeReference<EncapsulatedResponse<String>>() {
			});
		} catch (EncoderException | IOException e) {
			return false;
		}
		return incResponse != null && incResponse.getResult() != null && incResponse.getResult().equalsIgnoreCase("ok");

	}

	public EncapsulatedResponse<TaskItem> getTask(int taskId) {
		HttpGet httpget = null;
		HttpEntity entity = null;
		EncapsulatedResponse<TaskItem> incResponse = null;
		try {
			httpget = new HttpGet(url + "?key=" + key + "&cat=task&action=show&id=" + taskId);
			HttpResponse response = httpclient.execute(httpget);
			entity = response.getEntity();
			incResponse = objectMapper.readValue(entity.getContent(), new TypeReference<EncapsulatedResponse<TaskItem>>() {
			});
		} catch (IOException e) {
			return null;
		}
		return incResponse;
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
