package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.EncoderException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSideInventoryApi extends AbstractUserSideClient {
	public UserSideInventoryApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideInventoryApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
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
}
