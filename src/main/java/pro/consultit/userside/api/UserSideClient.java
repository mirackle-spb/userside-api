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
import pro.consultit.userside.api.items.*;

import java.io.IOException;
import java.util.HashMap;
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

	public IncapsulatedResponse<Map<Integer, CommutationListItem[]>> getCommutationList(int deviceId) throws IOException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=commutation&action=get_data&object_type=switch&is_finish_data=1&object_id=" + deviceId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IncapsulatedResponse<Map<Integer, CommutationListItem[]>>>() {
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
	 * Looking for item inventory id by asset number
	 *
	 * @param inventoryId inventoryId
	 * @return id of inventory item or null if not found
	 * @throws IOException
	 * @throws EncoderException
	 */

	public IncapsulatedResponse<InventoryListItem> getInventoryById(int inventoryId) throws IOException, EncoderException {
		HttpGet httpget = new HttpGet(url + "?key=" + key + "&cat=inventory&action=get_inventory&id=" + inventoryId);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		return objectMapper.readValue(entity.getContent(), new TypeReference<IncapsulatedResponse<InventoryListItem>>() {
		});
	}
}
